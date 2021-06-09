package com.example.autentia.gestor.entity.dto;

import com.example.autentia.gestor.entity.dto.UserDTO;

public class CuentaDTO {

    private int id;

    private UserDTO user;

    private double balance;

    private boolean estadoBalance;

    public int getId() {
        return id;
    }

    public UserDTO getUs() {
        return user;
    }

    public void setUs(UserDTO us) {
        this.user = us;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isEstadoBalance() {
        return estadoBalance;
    }

    public void setEstadoBalance(boolean estado_balance) {
        this.estadoBalance = estado_balance;
    }
}
