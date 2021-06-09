package com.example.autentia.gestor.entity;

import javax.persistence.*;

@Entity
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @OneToOne
    private UserEntity user;

    @Column
    private double balance;

    @Column(nullable = true)
    private boolean estadoBalance;

    public int getId() {
        return id;
    }

    public UserEntity getUs() {
        return user;
    }

    public void setUs(UserEntity us) {
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
