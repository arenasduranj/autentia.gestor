package com.example.autentia.gestor.service;

import com.example.autentia.gestor.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    @Autowired
    CuentaRepository cuentaRepository;

    public List<Object> getBalance() {
        return cuentaRepository.getBalanceByUser();
    }
}
