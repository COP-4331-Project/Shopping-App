package com.finalproject.group11.model;

public class Customer extends User{

    private Cart cart;
    private double balance;

    public Customer(int id, String name, String password, Cart cart, double balance) {
        super(id, name, password);
        this.cart = cart;
        this.balance = balance;
    }


    /**
     * add_product_to_cart() - adds a product to the shopping cart
     *
     * */
    public void add_product_to_cart(Product product){}

    /***/
    public void view_product(Product product){}

    /***/
    public void browse_product(Product product){}

    /***/
    public void checkout(){}
}
