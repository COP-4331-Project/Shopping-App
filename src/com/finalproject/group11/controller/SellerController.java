package com.finalproject.group11.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.finalproject.group11.model.Product;
import com.finalproject.group11.model.Seller;

public class SellerController implements Serializable {
	
	Seller seller;
	ObjectOutputStream out = null;
	
	public SellerController() throws FileNotFoundException, IOException {
		 this.out = new ObjectOutputStream(new FileOutputStream("products.dat"));
	}
	
	public void addProductsToInventory() throws FileNotFoundException, IOException {
		this.out.writeObject(seller.get_seller_products_list());
		out.close();

	}
}
