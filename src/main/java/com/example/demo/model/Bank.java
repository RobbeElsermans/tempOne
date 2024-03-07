package com.example.demo.model;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;

    public Bank(){
        this.accounts = new HashMap<>();
    }

    public boolean createUser(AccountName fullName){
        if(fullName == null)
        {
            return false;
        }


        //Check if no collisions
        if( this.accounts.containsKey(fullName.toString()) )
            return false;

        //Add account
        accounts.put(fullName.toString(), new Account(fullName));

        return true; //Error
    }

    public double getUserBalance(AccountName fullName){

        if(fullName == null)
        {
            return -1;
        }

        //Check if no existence
        if(!this.accounts.containsKey(fullName.toString()) )
            return -1;

        //retrieve balance
        return this.accounts.get(fullName.toString()).GetBalance();
    }

    public double withdrawMoney(AccountName fullName, double amountOfMoney){
        if(fullName == null)
        {
            return -1;
        }

        //Check if no existence
        if(!this.accounts.containsKey(fullName.toString()))
            return -1;

        return this.accounts.get(fullName.toString()).WithdrawMoney(amountOfMoney);
    }

    public double addMoney(AccountName fullName, double amountOfMoney){
        if(fullName == null)
        {
            return -1;
        }

        //Check if no existence
        if(!this.accounts.containsKey(fullName.toString()))
            return -1;

        return this.accounts.get(fullName.toString()).AddMoney(amountOfMoney);
    }
}