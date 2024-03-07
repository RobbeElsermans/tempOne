package com.model;

import org.apache.catalina.User;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class BankModel {
    private HashMap<Integer, AccountModel> accounts;

    public BankModel(){
        this.accounts = new HashMap<>();
    }

    public boolean createUser(UserModel user){
        if(user == null)
        {
            return false;
        }

        //Check if no collisions
        for(AccountModel known : this.accounts.values()) {
            if (known.getFullName().equals(user.toString()))
                return false;
        }

        //Add account
        accounts.put(user.getId(), new AccountModel(user));

        return true; //Error
    }

    public double getUserBalance(int accountId){

        if(accountId == 0)
        {
            return -1;
        }

        //Check if not existence
        if(!this.accounts.containsKey(accountId) )
            return -1;

        //retrieve balance
        return this.accounts.get(accountId).GetBalance();
    }

    public double withdrawMoney(int accountId , double amountOfMoney){
        if(accountId == 0)
        {
            return -1;
        }

        //Check if no existence
        if(!this.accounts.containsKey(accountId))
            return -1;

        return this.accounts.get(accountId).WithdrawMoney(amountOfMoney);
    }

    public double addMoney(int accountId, double amountOfMoney){
        if(accountId == 0)
        {
            return -1;
        }

        //Check if no existence
        if(!this.accounts.containsKey(accountId))
            return -1;

        return this.accounts.get(accountId).AddMoney(amountOfMoney);
    }
}