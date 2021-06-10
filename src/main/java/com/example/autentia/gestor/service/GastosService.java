package com.example.autentia.gestor.service;

import com.example.autentia.gestor.entity.CuentaEntity;
import com.example.autentia.gestor.entity.GastoEntity;
import com.example.autentia.gestor.entity.UserEntity;
import com.example.autentia.gestor.entity.dto.CuentaDTO;
import com.example.autentia.gestor.entity.dto.GastoDTO;
import com.example.autentia.gestor.entity.dto.UserDTO;
import com.example.autentia.gestor.repository.CuentaRepository;
import com.example.autentia.gestor.repository.GastoRepository;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class GastosService {

    @Autowired
    GastoRepository gastoRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    public boolean ingresarGasto(GastoDTO gastoDTO) {
        GastoEntity gastoEntity = new GastoEntity();
        CuentaEntity cuentaEntity = cuentaRepository.findById(gastoDTO.getCuenta().getId()).get();

        gastoEntity.setCuenta(cuentaEntity);

        BeanUtils.copyProperties(gastoDTO, gastoEntity, "cuenta");

        gastoRepository.save(gastoEntity);

        calculoBalanceIngreso(gastoEntity.getCuenta(), gastoEntity.getImporte());

        calculoBalanceResto(cuentaRepository.findNotAll(gastoEntity.getCuenta().getId()), gastoEntity.getImporte());

        return true;
    }

    public List<Object> devolverGastos() {
        return gastoRepository.getAll();
    }

    public void calculoBalanceIngreso(CuentaEntity cuenta, double gasto) {
        double result = 0;

        if(cuenta.isEstadoBalance()) {
            result = cuenta.getBalance() + gasto;
        } else {
            if(cuenta.getBalance() > gasto) {
                result = cuenta.getBalance() - gasto;
            } else if(cuenta.getBalance() == gasto) {
                cuenta.setEstadoBalance(true);
            } else {
                result = gasto - cuenta.getBalance();
                cuenta.setEstadoBalance(true);
            }
        }

        cuenta.setBalance(result);

        cuentaRepository.save(cuenta);
    }

    public void calculoBalanceResto(List<CuentaEntity> cuentas, double gasto) {
        double result;
        double div = Math.round(gasto / cuentas.size());

        if(cuentas.size() > 0) {
            for(CuentaEntity cuenta: cuentas) {
                result = 0;
                if (cuenta.isEstadoBalance()) {
                    if(cuenta.getBalance() > div) {
                        result = cuenta.getBalance() - div;
                    } else if(cuenta.getBalance() > div) {
                        result = div - cuenta.getBalance();
                        cuenta.setEstadoBalance(false);
                    }
                } else {
                    result = cuenta.getBalance() + div;
                }

                cuenta.setBalance(result);

                cuentaRepository.save(cuenta);
            }
        }
    }
}
