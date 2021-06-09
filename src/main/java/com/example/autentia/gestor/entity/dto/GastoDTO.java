package com.example.autentia.gestor.entity.dto;

import com.example.autentia.gestor.entity.dto.CuentaDTO;

import java.util.Date;

public class GastoDTO {

    private int id;

    private CuentaDTO cuenta;

    private double importe;

    private String descripcion;

    private Date fecha;

    public int getId() {
        return id;
    }

    public CuentaDTO getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaDTO cuenta) {
        this.cuenta = cuenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
