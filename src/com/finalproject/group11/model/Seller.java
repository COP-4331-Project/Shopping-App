package com.finalproject.group11.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Seller extends User implements Serializable {

    // Seller Member Variables
    private ArrayList<Product> seller_products_list;
    private SellerReport report;
    private static final String role = "SELLER";

    // Seller Constructor
    public Seller(int id, String name, String password) {
        super(id, name, password);
        seller_products_list = new ArrayList<Product>();
    }

    // Seller Methods
    public void add_product_to_sell(Product product) {
        seller_products_list.add(product);
    }

    public void update_inventory() {
        // Allow the Seller to update the name, price, description, and quantity of all products
    }

    public void review_inventory() {
        // Allow the Seller to see the name, price, description, and quantity of all products
    }

    public void view_seller_report() {
        // Show the the current profit, revenue, and sales when the Seller selects to
    }

    public String getRole(){return this.role;}
}
