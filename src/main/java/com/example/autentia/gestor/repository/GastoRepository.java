package com.example.autentia.gestor.repository;

import com.example.autentia.gestor.entity.GastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GastoRepository extends JpaRepository<GastoEntity, Integer> {

    @Query("SELECT g.desc, g.importe, g.fecha, u.nombre, u.apellido FROM Gasto g JOIN Cuenta c ON c.id = g.cuenta_id ON User u ON u.id = c.user_id")
    public ArrayList<GastoEntity>() getAll();
}
