package com.model;

public class Account {

    private final AccountName fullName;
    private double balance;
    public Account(AccountName fullName){
        this.fullName = fullName;

        this.balance = 0.0;
    }

    public double GetBalance() {
        return balance;
    }
    public double AddMoney(double addition) {
        this.balance = this.balance + addition;
        return this.balance;
    }
    public double WithdrawMoney(double toBeWithdraw) {
        if(balance - toBeWithdraw < 0)
        {
           return -1;
        }
        this.balance = this.balance - toBeWithdraw;
        return this.balance;
    }
}
