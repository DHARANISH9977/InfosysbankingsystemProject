package com.infosys.bankingsystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Tranfer {

    @Id
    @GeneratedValue
    int id;
    double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCheck() {
        return checks;
    }

    public void setCheck(String checks) {
        this.checks = checks;
    }
 // link with account
    String checks;
}
