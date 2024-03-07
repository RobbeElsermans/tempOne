package com.model;

public class AccountName {
    private String firstName;
    private String lastName;

    public AccountName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
