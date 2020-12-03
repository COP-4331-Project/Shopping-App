package com.finalproject.group11.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
	int id;
	double total = 0;
	Cart cart;
	Date timestamp = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	private ArrayList<Product> getProducts() {
		return cart.getProductList();
	}
	
	public double getTotal() {
		this.getProducts().forEach(product -> {
			total += product.getPrice();
		});
		return total;
	}
	
	public void checkout() {
		
	}
	
	private void remove_from_inventory(ArrayList<Product> products) {
//		products.stream().map(product-> {
//			product.setQuantity(product.getPrice() - 1);
//		})
		
	}
}
