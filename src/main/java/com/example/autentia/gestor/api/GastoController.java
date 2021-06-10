package com.example.autentia.gestor.api;

import com.example.autentia.gestor.entity.GastoEntity;
import com.example.autentia.gestor.entity.dto.GastoDTO;
import com.example.autentia.gestor.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/gasto")
public class GastoController {

    @Autowired
    GastosService gastosService;

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody GastoDTO gastoDTO) {
        if(gastosService.ingresarGasto(gastoDTO)) {
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
