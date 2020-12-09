/**
 * Customer class, subclass of User
 * @author Ross Parsons
 * */
package com.finalproject.group11.model;

import java.io.Serializable;


public class Customer extends User implements Serializable {

    private Cart cart;
    private double balance;
    private static final String role = "CUSTOMER";

    /**
     * Customer constructor calls the super constructor and adds to additional attributes,
     * a Cart object and a balance.
     * note: balance is set at time of custmer creation
     * */
    public Customer(int id, String name, String password, Cart cart, double balance) {
        super(id, name, password);
        this.cart = cart;
        this.balance = balance;
    }


    public String getRole(){return this.role;}

    @Override
    public String toString() {
        return "Customer{" +
                super.getUsername() + ", "
                + " password: " +
                super.getPassword() + " " +
                ", balance=" + balance +
                '}';
    }
}
