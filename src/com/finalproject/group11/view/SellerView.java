package com.finalproject.group11.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.finalproject.group11.model.Product;
import com.finalproject.group11.model.Seller;

public class SellerView {
	private Seller seller;
	
	public SellerView(Seller seller) {
		this.seller = seller;
	}
	
	// Creates a button to access new product page
	private JButton createAddProductButton(JPanel panel) {
		JButton addProductButton = new JButton("Add a new product");
		addProductButton.addActionListener(
				new ActionListener() {
	        		public void actionPerformed(ActionEvent event) {
	        			panel.removeAll();
	        			panel.add(displayAddProductPanel());
	        			panel.revalidate();
	        			panel.repaint();
	        		}
				}
			);
		return addProductButton;
	}
	
	// Creates the initial seller panel upon login
	private JPanel createSellerPanel() {
		JPanel sellerPanel = new JPanel();
		sellerPanel.setLayout(new FlowLayout());
		sellerPanel.setBackground(Color.white);

		JButton addProductButton = createAddProductButton(sellerPanel);
		sellerPanel.add(addProductButton);
		return sellerPanel;
	}
	
	// Displays a panel with functionality to add a new product
	private JPanel displayAddProductPanel() {
		JPanel addProductPanel = new JPanel();
				
		JTextField newProductName = new JTextField("Name", 15);
		JTextField newProductImageSrc = new JTextField("Image", 15);
		JTextField newProductPrice = new JTextField("Price", 15);
		JTextField newProductQuantity= new JTextField("Quantity", 15);
		JTextField newProductDescription = new JTextField("Description", 15);
				
		addProductPanel.add(newProductName);
		addProductPanel.add(newProductImageSrc);
		addProductPanel.add(newProductPrice);
		addProductPanel.add(newProductQuantity);
		addProductPanel.add(newProductDescription);
		
		JButton submitProductButton = new JButton("Submit new product");
		submitProductButton.addActionListener(
				new ActionListener() {
	        		public void actionPerformed(ActionEvent event) {
	        			Product newProduct = new Product(new Random().nextInt(), newProductName.getText(),
	        					Double.parseDouble(newProductPrice.getText()), newProductDescription.getText(),
	        					Integer.parseInt(newProductQuantity.getText()));
	        			seller.add_product_to_sell(newProduct);
	        			addProductPanel.removeAll();
	        			addProductPanel.add(createAddProductButton(addProductPanel));
	        			addProductPanel.add(displaySellerInventory());
	        			addProductPanel.revalidate();
	        			addProductPanel.repaint();
	        			System.out.println("New product added.");
	        		}
				}
			);
		
		addProductPanel.add(submitProductButton);
		
		return addProductPanel;
	}
	
	// Displays a panel with functionality to edit an existing product
	private JPanel displayEditProductPanel(Seller seller, Product currentProduct) {
		JPanel editProductPanel = new JPanel();
				
		JTextField newProductName = new JTextField(currentProduct.getName(), 15);
		JTextField newProductImageSrc = new JTextField("Source", 15);
		JTextField newProductPrice = new JTextField(String.valueOf(currentProduct.getPrice()), 15);
		JTextField newProductQuantity= new JTextField(String.valueOf(currentProduct.getQuantity()), 15);
		JTextField newProductDescription = new JTextField(currentProduct.getName(), 15);
				
		editProductPanel.add(newProductName);
		editProductPanel.add(newProductImageSrc);
		editProductPanel.add(newProductPrice);
		editProductPanel.add(newProductQuantity);
		editProductPanel.add(newProductDescription);
		
		JButton submitProductButton = new JButton("Update product");
		editProductPanel.add(submitProductButton);
		
		submitProductButton.addActionListener(
				new ActionListener() {
	        		public void actionPerformed(ActionEvent event) {
	        			Product updatedProduct = new Product(currentProduct.getId(), newProductName.getText(), Double.parseDouble(newProductPrice.getText()),
	        					newProductDescription.getText(), Integer.parseInt(newProductQuantity.getText()));
	        			seller.update_inventory(updatedProduct);
	        			editProductPanel.removeAll();
	        			editProductPanel.add(displaySellerInventory());
	        			editProductPanel.revalidate();
	        			editProductPanel.repaint();
	        		}
				}
			);
		
		
		return editProductPanel;
	}
		
	// Displays the seller's current inventory
	private JPanel displaySellerInventory() {
		ProductView productView = new ProductView(25, 50);
		JPanel allProductsPanel = new JPanel();
		seller.get_seller_products_list().forEach(product -> {
			JPanel productPanel = productView.createProductPanel(product.getName(), product.getPrice(),
					product.getQuantity(), product.getDescription());
			JButton editButton = new JButton("Edit");
			productPanel.add(editButton);
			editButton.addActionListener(
					new ActionListener() {
		        		public void actionPerformed(ActionEvent event) {
		        			System.out.println(product.getName());
		        			allProductsPanel.removeAll();
		        			JPanel editProductPanel = displayEditProductPanel(seller, product);
		        			allProductsPanel.add(editProductPanel);
		        			allProductsPanel.revalidate();
		        			allProductsPanel.repaint();
//		        			allProductsPanel.add()
		        		}
					}
				);
			allProductsPanel.add(productPanel);
		});
		
		return allProductsPanel;
	}
	
	public static void main(String[] args) {
		Seller seller = new Seller(1, "Matt", "password");
		SellerView sellerView = new SellerView(seller);
		
		JFrame frame = new JFrame("SellerView");
		JPanel sellerPanel = sellerView.createSellerPanel();

		Product newProduct1 = new Product(127, "Xbox", 499.99, "New console by Microsoft.", 0);
		seller.add_product_to_sell(newProduct1);

		JPanel allProductsPanel = sellerView.displaySellerInventory();
		sellerPanel.add(allProductsPanel);
		
		frame.add(sellerPanel);
        frame.setSize(640, 480);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
	}
}
