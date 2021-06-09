package com.example.autentia.gestor.api;

import com.example.autentia.gestor.entity.GastoEntity;
import com.example.autentia.gestor.entity.dto.GastoDTO;
import com.example.autentia.gestor.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gasto/")
public class GastoController {

    @Autowired
    GastosService gastosService;

    @PostMapping(value = "/")
    public ResponseEntity create(GastoDTO gastosDTO) {
        if(gastosService.ingresarGasto(gastosDTO)) {
            return new ResponseEntity<>("Gasto Añadido", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    public List<Object> getAll() {
        return gastosService.devolverGastos();
    }
}
