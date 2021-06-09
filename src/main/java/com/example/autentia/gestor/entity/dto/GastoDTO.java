package com.example.autentia.gestor.entity.dto;

import com.example.autentia.gestor.entity.dto.CuentaDTO;

import java.util.Date;

public class GastoDTO {

    private int id;

    private CuentaDTO cuenta;

    private double importe;

    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
