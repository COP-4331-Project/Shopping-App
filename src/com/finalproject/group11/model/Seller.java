package com.finalproject.group11.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.finalproject.group11.controller.ProductController;

public class Seller extends User implements Serializable {

    // Seller Member Variables
    private ArrayList<Product> seller_products_list;
    private SellerReport report;
    private static final String role = "SELLER";
    ProductController sellerController;

    // Seller Constructor
    public Seller(int id, String name, String password) {
        super(id, name, password);
        this.seller_products_list = new ArrayList<Product>();
    }

    // Seller Methods
    public void add_product_to_sell(Product product) {
        this.seller_products_list.add(product);
//        System.out.println(this.seller_products_list.get(0).getName());
//        sellerController.addProductToInventory(this.seller_products_list);
    }

    public void update_inventory(Product updatedProduct) {
        // Allow the Seller to update the name, price, description, and quantity of all products
    	for (int i = 0; i < this.get_seller_products_list().size(); i++) {
    		if (updatedProduct.getId() == this.get_seller_products_list().get(i).getId()) {
    			this.seller_products_list.remove(i);
    			this.seller_products_list.add(updatedProduct);
//    			sellerController.addProductToInventory(this.seller_products_list);
    			System.out.println("product updated:");
    		}
    	}
    }

    public void review_inventory() {
        // Allow the Seller to see the name, price, description, and quantity of all products
    }

    public void view_seller_report() {
        // Show the the current profit, revenue, and sales when the Seller selects to
    }

    public String getRole(){return this.role;}

	public ArrayList<Product> get_seller_products_list() {
//		this.seller_products_list = sellerController.getProductsBySellerId(getId());
		return this.seller_products_list;
	}
}
