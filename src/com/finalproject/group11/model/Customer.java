package com.finalproject.group11.model;

import java.util.Hashtable;

public class Customer extends User{

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


    /**
     * add_product_to_cart() - adds a product to the shopping cart
     * @precondition: product exists in Inventory
     * @postcondition: product is added to cart object
     * */
    public void add_product_to_cart(Product product){}

    /**
     * view_product() - brings up a swing component displaying product info
     * note: 'void' may not be the return value, and instead a swing component
     * */
    public void view_product(Product product){}


    /**
     * checkout() - brings customer to checkout pane
     * note: 'void' may not be the return value, and instead a swing component
     *
     * @precondition:
     * @postcondition:
     * */
    public void checkout(){}

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
