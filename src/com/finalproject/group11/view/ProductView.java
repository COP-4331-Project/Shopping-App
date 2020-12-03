package com.finalproject.group11.view;

import com.finalproject.group11.model.Cart;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

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

    public JPanel createProductPanel(String title, String imgPath, double price, int units, String desc) {
        // Making and defining the product panel
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new FlowLayout());
        productPanel.setBackground(Color.white);

        // Adding the product title and image to the productPanel
        productPanel.add(new JLabel(title), SwingConstants.CENTER);
        ImageIcon img = new ImageIcon(imgPath);
        Image imgResize = img.getImage();
        Image newImg = imgResize.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newImg);
        productPanel.add(new JLabel(img));

        // Making and defining the infoPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5,1));
        infoPanel.setBackground(Color.WHITE);

        // Arranging the infoPanel vertically
        infoPanel.add(new JLabel("Price: $" + price, SwingConstants.CENTER), new GridLayout(1,1));
        JLabel unitsLabel = new JLabel("Units: " + units, SwingConstants.CENTER);
        infoPanel.add(unitsLabel, new GridLayout(2,1));
        infoPanel.add(new JLabel(desc, SwingConstants.CENTER), new GridLayout(3,1));
        JButton buyBtn = new JButton("Buy Now!");
        // Add a buy btn action listener
        buyBtn.addActionListener(e -> {
            System.out.println("Buy button pressed for " + title);
            if(title.equals("Apple") && appleCount < units) {
                appleCount += 1;
                // Call the method to decrement the number of units of a product
                // Set the text of the units label again
                unitsLabel.setText("Units: " + (units - appleCount));
                // Add the price of the item to the shopping cart subtotal
                this.subtotal += price;
                subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                System.out.println("The subtotal is now $" + this.subtotal);
            } else if(title.equals("Orange") && orangeCount < units) {
                orangeCount += 1;
                // Call the method to decrement the number of units of a product
                // Set the text of the units label again
                unitsLabel.setText("Units: " + (units - orangeCount));
                // Add the price of the item to the shopping cart subtotal
                this.subtotal += price;
                subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                System.out.println("The subtotal is now $" + this.subtotal);
            } else if(title.equals("Bananas") && bananasCount < units) {
                bananasCount += 1;
                // Call the method to decrement the number of units of a product
                // Set the text of the units label again
                unitsLabel.setText("Units: " + (units - bananasCount));
                // Add the price of the item to the shopping cart subtotal
                this.subtotal += price;
                subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                System.out.println("The subtotal is now $" + this.subtotal);
            } else if(title.equals("Kiwi") && kiwiCount < units) {
                kiwiCount += 1;
                // Call the method to decrement the number of units of a product
                // Set the text of the units label again
                unitsLabel.setText("Units: " + (units - kiwiCount));
                // Add the price of the item to the shopping cart subtotal
                this.subtotal += price;
                subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                System.out.println("The subtotal is now $" + this.subtotal);
            } else if(title.equals("Mango") && mangoCount < units) {
                mangoCount += 1;
                // Call the method to decrement the number of units of a product
                // Set the text of the units label again
                unitsLabel.setText("Units: " + (units - mangoCount));
                // Add the price of the item to the shopping cart subtotal
                this.subtotal += price;
                subtotalLabel.setText(String.format("Shopping Cart Subtotal: $%.2f", this.subtotal));
                System.out.println("The subtotal is now $" + this.subtotal);
            }
        });
        infoPanel.add(buyBtn, new GridLayout(4,1));

        // Add the productPanel to the productContainer
        productPanel.add(infoPanel);
        return productPanel;
    }

    public void setUPGUI(JPanel ...productPanel) {
        // Making and defining the frame
        JFrame frame = new JFrame("ProductView");
        frame.setLayout(new BorderLayout());
        frame.setSize(width, height);
        frame.setBounds(0,0, 400,400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(200,200,200));

        // Making and defining the productContainer
        JPanel productContainer = new JPanel();
        productContainer.setLayout(new GridLayout(6,1));
        productContainer.setBackground(Color.BLACK);

        // Adding the productPanel(s) to the productContainer
        int rows = 1;
        int cols = 1;
        for(JPanel i: productPanel) {
            productContainer.add(i, new GridLayout(rows, cols));
            rows += 1;
        }

        // Making and defining the product panel
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new GridLayout(3,1));
        checkoutPanel.setBackground(Color.white);
        System.out.println("New Subtotal Value: $" + subtotal);
        checkoutPanel.add(subtotalLabel, new GridLayout(1, 1));
        checkoutPanel.add(new JLabel("Finished Shopping?", SwingConstants.CENTER), new GridLayout(2, 1));
        JButton checkoutBtn = new JButton("Checkout");
        checkoutPanel.add(checkoutBtn, new GridLayout(3, 1));

        productContainer.add(checkoutPanel, new GridLayout(rows, cols));

        JScrollPane productContainerScroll = new JScrollPane();
        productContainerScroll.setViewportView(productContainer);
        frame.add(productContainerScroll);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ProductView myPV = new ProductView(500, 500);

        // Create productPanels
        JPanel applePanel = myPV.createProductPanel("Apple","apple.jpg", 1.99, 25, "Freshly Picked!");
        JPanel orangePanel = myPV.createProductPanel("Orange","orange.jpg", 1.49, 44, "Citrus Sweetness!");
        JPanel bananaPanel = myPV.createProductPanel("Bananas","bananas.jpg", 3.75, 12, "Ripe & Ready!");
        JPanel kiwiPanel = myPV.createProductPanel("Kiwi","kiwi.jpg", 1.25, 36, "Green Goodness!");
        JPanel mangoPanel = myPV.createProductPanel("Mango","mango.jpg", 2.25, 47, "Mango Madness!");

        // Add the productPanels to the productContainer
        myPV.setUPGUI(applePanel, orangePanel, bananaPanel, kiwiPanel, mangoPanel);
    }
}
