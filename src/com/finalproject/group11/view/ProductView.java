package com.finalproject.group11.view;

import javax.swing.*;

import com.finalproject.group11.model.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductView extends JFrame {

    private int width;
    private int height;
    private int appleCount = 0;
    private int orangeCount = 0;
    private int bananasCount = 0;
    private int kiwiCount = 0;
    private int mangoCount = 0;
    private double subtotal = 0;
    private JLabel subtotalLabel = new JLabel("Shopping Cart Subtotal: $" + this.subtotal, SwingConstants.CENTER);

    public ProductView(int w, int h) {
        width = w;
        height = h;
    }

    /**
     * Creates a product panel of an item available in the store
     * @return JPanel of an item available in the store
     * @author Julian-Justin Djoum
     **/
    public JPanel createProductPanel(Product product, String imgSrc, boolean isCustomer) {

        // Making and defining the product panel
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new FlowLayout());
        productPanel.setBackground(Color.white);

        // Adding the product title and image to the productPanel
        productPanel.add(new JLabel(product.getName()), SwingConstants.CENTER);
        ImageIcon img = new ImageIcon(imgSrc);
        Image imgResize = img.getImage();
        Image newImg = imgResize.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newImg);
        productPanel.add(new JLabel(img));

        // Making and defining the infoPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5,1));
        infoPanel.setBackground(Color.WHITE);

        // Arranging the infoPanel vertically
        infoPanel.add(new JLabel("Price: $" + product.getPrice(), SwingConstants.CENTER), new GridLayout(1,1));
        JLabel unitsLabel = new JLabel("Units: " + product.getQuantity(), SwingConstants.CENTER);
        infoPanel.add(unitsLabel, new GridLayout(2,1));
        infoPanel.add(new JLabel(product.getDescription(), SwingConstants.CENTER), new GridLayout(3,1));
        if (isCustomer) {
        	JButton buyBtn = new JButton("Buy Now!");

            // Add a buyBtn action listener
            buyBtn.addActionListener(e -> {
                System.out.println("Buy button pressed for " + product.getName());

                if(product.getName().equals("Apple") && appleCount < product.getQuantity()) {
                    appleCount += 1;
                    // Call the method to decrement the number of units of a product
                    // Set the text of the units label again
                    unitsLabel.setText("Units: " + (product.getQuantity() - appleCount));
                    // Add the price of the item to the shopping cart subtotal
                    this.subtotal += product.getPrice();
                    subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                    System.out.println("The subtotal is now $" + this.subtotal);

                } else if(product.getName().equals("Orange") && orangeCount < product.getQuantity()) {
                    orangeCount += 1;
                    // Call the method to decrement the number of units of a product
                    // Set the text of the units label again
                    unitsLabel.setText("Units: " + (product.getQuantity() - orangeCount));
                    // Add the price of the item to the shopping cart subtotal
                    this.subtotal += product.getPrice();
                    subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                    System.out.println("The subtotal is now $" + this.subtotal);

                } else if(product.getName().equals("Bananas") && bananasCount < product.getQuantity()) {
                    bananasCount += 1;
                    // Call the method to decrement the number of units of a product
                    // Set the text of the units label again
                    unitsLabel.setText("Units: " + (product.getQuantity() - bananasCount));
                    // Add the price of the item to the shopping cart subtotal
                    this.subtotal += product.getPrice();
                    subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                    System.out.println("The subtotal is now $" + this.subtotal);

                } else if(product.getName().equals("Kiwi") && kiwiCount < product.getQuantity()) {
                    kiwiCount += 1;
                    // Call the method to decrement the number of units of a product
                    // Set the text of the units label again
                    unitsLabel.setText("Units: " + (product.getQuantity() - kiwiCount));
                    // Add the price of the item to the shopping cart subtotal
                    this.subtotal += product.getPrice();
                    subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                    System.out.println("The subtotal is now $" + this.subtotal);

                } else if(product.getName().equals("Mango") && mangoCount < product.getQuantity()) {
                    mangoCount += 1;
                    // Call the method to decrement the number of units of a product
                    // Set the text of the units label again
                    unitsLabel.setText("Units: " + (product.getQuantity() - mangoCount));
                    // Add the price of the item to the shopping cart subtotal
                    this.subtotal += product.getPrice();
                    subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                    System.out.println("The subtotal is now $" + this.subtotal);
                }
            });
            infoPanel.add(buyBtn, new GridLayout(4,1));
        }
        
        // Add the productPanel to the productContainer
        productPanel.add(infoPanel);
        return productPanel;
    }

    /**
     * Sets up the Store GUI
     * @return void
     * @author Julian-Justin Djoum
     **/
    public void setUPGUI(JPanel ...productPanel) {
        // Making and defining the frame
        JFrame frame = new JFrame("Product View");
        frame.setLayout(new BorderLayout());
        frame.setSize(width, height);
        frame.setBounds(0,0, 1000,1000);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(200,200,200));

        // Making and defining the productContainer
        JPanel productContainer = new JPanel();
        productContainer.setLayout(new GridLayout(7,1));
        productContainer.setBackground(Color.WHITE);

        // Making a Store title JLabel
        JLabel storeTitle = new JLabel("Store", SwingConstants.CENTER);
        storeTitle.setForeground(Color.BLACK);
        storeTitle.setFont(new Font("Arial",Font.BOLD,30));
        productContainer.add(storeTitle, new GridLayout(1,1));

        // Adding the productPanel(s) to the productContainer
        int rows = 2;
        int cols = 1;
        for(JPanel i: productPanel) {
            productContainer.add(i, new GridLayout(rows, cols));
            rows += 1;
        }

        // Making and defining the checkoutPanel
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new GridLayout(3,1));
        checkoutPanel.setBackground(Color.white);
        System.out.println("New Subtotal Value: $" + subtotal);
        checkoutPanel.add(subtotalLabel, new GridLayout(1, 1));
        checkoutPanel.add(new JLabel("Finished Shopping?", SwingConstants.CENTER), new GridLayout(2, 1));
        JButton checkoutBtn = new JButton("Checkout");

        // Add a checkoutBtn action listener
        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (subtotal > 0) {
                    frame.dispose();
                    // Create the checkoutView
                    CheckoutView myCV = new CheckoutView(appleCount, orangeCount, bananasCount, kiwiCount, mangoCount, subtotal);
                }
            }
        });

        // Adding the checkoutBtn to the productContainer
        checkoutPanel.add(checkoutBtn, new GridLayout(3, 1));

        // Adding the checkoutPanel to the productContainer
        productContainer.add(checkoutPanel, new GridLayout(rows, cols));

        JScrollPane productContainerScroll = new JScrollPane();
        productContainerScroll.setViewportView(productContainer);
        frame.add(productContainerScroll);
        frame.pack();
        frame.setVisible(true);
    }
}
