package com.example.autentia.gestor.repository;

import com.example.autentia.gestor.entity.GastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<GastoEntity, Integer> {

    @Query(value = "SELECT g.descripcion, g.importe, g.fecha, u.nombre, u.apellido FROM GastoEntity g JOIN CuentaEntity c ON c.id = g.cuenta.id JOIN UserEntity u ON u.id = c.user.id")
    List<Object> getAll();
}
