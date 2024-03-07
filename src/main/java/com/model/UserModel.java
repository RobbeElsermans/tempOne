package com.model;

public class UserModel {
    private String firstName;
    private String lastName;
    private int id;

    public UserModel(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = (int) Math.floor(Math.random() * (1000 - 1 + 1) + 1);
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
