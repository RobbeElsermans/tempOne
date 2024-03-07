package com.model;

public class AccountModel {

    private final UserModel user;
    private double balance;
    public AccountModel(UserModel user){
        this.user = user;

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
    public String getFullName(){
        return this.user.toString();
    }
}
