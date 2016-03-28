package com.example.wasabi.espressolabexercise;

import java.io.Serializable;

/**
 * Created by Wasabi on 3/28/2016.
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    private String username;
    private String email;
    private String accountNum;
    private double balance;

    public Account(double balance) {
        this.accountNum = "123-456-7890";
        this.balance = balance;
        this.email = "ga@generalassemb.ly";
        this.username = "Wasabi Mayo";
    }

    public void withdrawMoney(double amount){
        setBalance(getBalance() - amount);
    }

    public void depositMoney(double amount){
        setBalance(getBalance() + amount);
    }


    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
