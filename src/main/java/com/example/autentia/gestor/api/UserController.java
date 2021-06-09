package com.example.autentia.gestor.api;

import com.example.autentia.gestor.entity.dto.UserAccess;
import com.example.autentia.gestor.entity.dto.UserDTO;
import com.example.autentia.gestor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody UserDTO userDTO) {
        if(userService.crearUsuario(userDTO)) {
            return new ResponseEntity<>("Usuario Creado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserAccess user) {
        if(userService.existeUser(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
