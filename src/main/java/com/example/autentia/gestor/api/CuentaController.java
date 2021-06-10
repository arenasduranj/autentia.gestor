package com.example.autentia.gestor.api;

import com.example.autentia.gestor.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {


    @Autowired
    CuentaService cuentaService;

    @GetMapping(value = ("/balance/"))
    public List<Object> getBalance() {
        return cuentaService.getBalance();
    }
}
