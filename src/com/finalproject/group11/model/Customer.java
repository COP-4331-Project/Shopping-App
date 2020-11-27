package com.finalproject.group11.model;

public class Customer extends User{

    private Cart cart;
    private double balance;

    public Customer(int id, String name, String password, Cart cart, double balance) {
        super(id, name, password);
        this.cart = cart;
        this.balance = balance;
    }
}
