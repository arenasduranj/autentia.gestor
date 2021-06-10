package com.example.autentia.gestor.service;

import com.example.autentia.gestor.entity.CuentaEntity;
import com.example.autentia.gestor.entity.UserEntity;
import com.example.autentia.gestor.entity.dto.UserAccess;
import com.example.autentia.gestor.entity.dto.UserDTO;
import com.example.autentia.gestor.repository.CuentaRepository;
import com.example.autentia.gestor.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    public boolean crearUsuario(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDTO, userEntity);

        userRepository.save(userEntity);

        CuentaEntity cuentaEntity = new CuentaEntity();

        cuentaEntity.setUser(userEntity);

        cuentaRepository.save(cuentaEntity);

        if(userRepository.existsById(userEntity.getId()) && cuentaRepository.existsById(cuentaEntity.getId() )) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existeUser(UserAccess user) {
        if(userRepository.findByEmailAndPass(user.getEmail(), user.getPass())) {
            return true;
        } else {
            return false;
        }
    }
}
