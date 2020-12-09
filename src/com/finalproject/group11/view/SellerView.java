package com.finalproject.group11.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.finalproject.group11.controller.SellerController;
import com.finalproject.group11.model.Product;
import com.finalproject.group11.model.Seller;
import com.finalproject.group11.model.SellerReport;

public class SellerView {
	private Seller seller;
	private SellerController sellerController;
	
	public SellerView(Seller seller) throws FileNotFoundException, IOException {
		this.seller = seller;
		this.sellerController = new SellerController();
	}
	
	/**
	 * Returns a JButton that allows for adding new products
	 * @param JPanel to add the button to
	 * @return JButton with actionListener
	 * @author Matthew Taylor
	 *  */
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
	
	/**
	 * Creates the initial seller panel upon login
	 * @return parent JPanel to add other components to
	 * @author Matthew Taylor
	 *  */
	private JPanel createSellerPanel() {
		JPanel sellerPanel = new JPanel();
		sellerPanel.setLayout(new FlowLayout());
		sellerPanel.setBackground(Color.white);

		return sellerPanel;
	}
	
	/**
	 * Creates a panel that allows for new product detail entry
	 * @return JPanel with text fields for new product
	 * @author Matthew Taylor
	 *  */
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
	
	/**
	 * Displays a panel with functionality to edit an existing product
	 * @param seller B
	 * @return JPanel with text fields to edit existing product's info
	 * @author Matthew Taylor
	 *  */
	private JPanel displayEditProductPanel(Seller seller, Product currentProduct) {
		JPanel editProductPanel = new JPanel();
				
		JTextField newProductName = new JTextField(currentProduct.getName(), 15);
		JTextField newProductImageSrc = new JTextField("Source", 15);
		JTextField newProductPrice = new JTextField(String.valueOf(currentProduct.getPrice()), 15);
		JTextField newProductQuantity= new JTextField(String.valueOf(currentProduct.getQuantity()), 15);
		JTextField newProductDescription = new JTextField(currentProduct.getDescription(), 15);
				
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
						try {
							seller.update_inventory(updatedProduct);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}

	        			editProductPanel.removeAll();
	        			editProductPanel.add(displaySellerInventory());
	        			editProductPanel.revalidate();
	        			editProductPanel.repaint();
	        		}
				}
			);
		
		
		return editProductPanel;
	}
		
	/**
	 * Displays the seller's current inventory
	 * @return JPanel with views for each product in seller's inventory
	 * @author Matthew Taylor
	 *  */
	public JPanel displaySellerInventory() {
		SellerView sellerView = this;
		
		ProductView productView = new ProductView(25, 50);
		JPanel allProductsPanel = new JPanel();
		
		SellerReport sellerReport = new SellerReport(1);
		sellerReport.setProfit(1);
		SellerReportView sellerReportView = new SellerReportView(sellerReport);
		
		JButton viewSellerReportButton = new JButton("View business details");
		allProductsPanel.add(viewSellerReportButton);
		viewSellerReportButton.addActionListener(
				new ActionListener() {
	        		public void actionPerformed(ActionEvent event) {
	        			allProductsPanel.removeAll();
	        			allProductsPanel.add(sellerReportView.createSellerReportPanel(sellerView));
	        			allProductsPanel.revalidate();
	        			allProductsPanel.repaint();
	        		}
				}
			);
		
		seller.get_seller_products_list().forEach(product -> {
			JPanel productPanel = productView.createProductPanel(product.getName(), null, product.getPrice(),
					product.getQuantity(), product.getDescription(), false);
			
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
		        		}
					}
				);
			allProductsPanel.add(productPanel);
		});
		
		JButton addProductButton = createAddProductButton(allProductsPanel);
		allProductsPanel.add(addProductButton);
		
		return allProductsPanel;
	}
	
	public static void setUpGui(Seller seller) throws FileNotFoundException, IOException
	{
		//TODO pass seller as arg

		//Seller seller = new Seller(1, "Matt", "password");
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
