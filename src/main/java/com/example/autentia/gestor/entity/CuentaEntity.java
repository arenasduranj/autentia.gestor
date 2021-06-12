package com.example.autentia.gestor.entity;

import javax.persistence.*;

@Entity
@Table(name="cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private UserEntity user;

    @Column
    private double balance;

    @Column(nullable = true)
    private boolean estadoBalance;

    public int getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity us) {
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
