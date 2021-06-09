package com.example.autentia.gestor.repository;

import com.example.autentia.gestor.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {

    @Query(value = "SELECT u.nombre, u.apellido, c.balance, c.estadoBalance FROM UserEntity u JOIN CuentaEntity c ON u.id = c.user.id")
    List<Object> getBalanceByUser();
}
