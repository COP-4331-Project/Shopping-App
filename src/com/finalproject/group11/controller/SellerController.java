package com.finalproject.group11.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.finalproject.group11.model.Product;
import com.finalproject.group11.model.Seller;

public class SellerController implements Serializable {
	
	Seller seller;
	ObjectOutputStream out = null;
	ObjectInputStream in = null;
	
	/**
	 * Constructs new SellerController object
	 * @return SellerController
	 * @author Matthew Taylor
	 *  */
	public SellerController() throws FileNotFoundException, IOException {
		 this.out = new ObjectOutputStream(new FileOutputStream("products.dat"));
		 this.in = new ObjectInputStream(new FileInputStream("products.dat"));
	}
	
	/**
	 * Serializes a Seller's list of products
	 * @author Matthew Taylor
	 *  */
	public void addProductsToInventory() throws FileNotFoundException, IOException {
		this.out.writeObject(seller.get_seller_products_list());
		out.close();
	}
	
	/**
	 * Returns a Seller's list of products from inventory
	 * @return list of Product under sellerId
	 * @author Matthew Taylor
	 *  */
	public ArrayList<Product> getProductsFromInventory() throws FileNotFoundException, IOException {
		ArrayList<Product> productsList = new ArrayList<>();
		try {
			productsList = (ArrayList<Product>) 	in.readObject();
			in.close();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return productsList;
	}
}
