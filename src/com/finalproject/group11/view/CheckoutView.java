package com.finalproject.group11.view;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CheckoutView extends JFrame {

    public JPanel createBoughtProductPanel(String title, String imgPath, double price, int unitsBought) {
        JPanel boughtProduct = new JPanel();
        boughtProduct.setLayout(new FlowLayout());
        boughtProduct.setBackground(Color.white);

        // Adding the product title and image to the boughtProduct panel
        boughtProduct.add(new JLabel(title), SwingConstants.CENTER);
        ImageIcon img = new ImageIcon(imgPath);
        Image imgResize = img.getImage();
        Image newImg = imgResize.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newImg);
        boughtProduct.add(new JLabel(img));

        // Making and defining the infoPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2,1));
        infoPanel.setBackground(Color.WHITE);

        // Arranging the infoPanel vertically
        infoPanel.add(new JLabel("Price: $" + price, SwingConstants.CENTER), new GridLayout(1,1));
        JLabel unitsLabel = new JLabel("Units In Cart: " + unitsBought, SwingConstants.CENTER);
        infoPanel.add(unitsLabel, new GridLayout(2,1));

        // Adding the infoPanel to the boughtProduct panel
        boughtProduct.add(infoPanel);
        return boughtProduct;
    }

    public CheckoutView (int appleCount, int orangeCount, int bananasCount, int kiwiCount, int mangoCount, double subtotal) {

        // Making and defining the frame
        JFrame frame = new JFrame("CheckoutView");
        frame.setLayout(new BorderLayout());
        frame.setSize(500,500);
        frame.setBounds(0,0, 400,400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(200,200,200));

        // Calculating the numRows that the productContainer needs
        int count[] = {appleCount, orangeCount, bananasCount, kiwiCount, mangoCount};
        int numRows = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                numRows += 1;
            }
        }

        // Making and defining the productContainer
        JPanel productContainer = new JPanel();
        productContainer.setLayout(new GridLayout(numRows + 4,1));
        productContainer.setBackground(Color.WHITE);

        // Making a Checkout title JLabel
        JLabel storeTitle = new JLabel("Checkout", SwingConstants.CENTER);
        storeTitle.setForeground(Color.BLACK);
        storeTitle.setFont(new Font("Arial",Font.BOLD,30));
        productContainer.add(storeTitle, new GridLayout(1,1));

        // Making a Your Shopping Cart JLabel
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        JLabel purchaseTime = new JLabel("Your Shopping Cart:", SwingConstants.CENTER);
        purchaseTime.setFont(new Font("Arial",Font.BOLD,15));
        productContainer.add(purchaseTime, new GridLayout(1,2));

        // Only load the items into the productContainer that the buyer bought
        int rows = 3;
        int cols = 1;

        if(appleCount > 0) {
            JPanel applePanel = createBoughtProductPanel("Apple", "assets/images/apple.jpg", 1.99, appleCount);
            productContainer.add(applePanel, new GridLayout(rows,cols));
            rows += 1;
        }
        if (orangeCount > 0) {
            JPanel orangePanel = createBoughtProductPanel("Orange", "assets/images/orange.jpg", 1.49, orangeCount);
            productContainer.add(orangePanel, new GridLayout(rows,cols));
            rows += 1;
        }
        if (bananasCount > 0) {
            JPanel bananasPanel = createBoughtProductPanel("Bananas", "assets/images/bananas.jpg", 3.75, bananasCount);
            productContainer.add(bananasPanel, new GridLayout(rows,cols));
            rows += 1;
        }
        if (kiwiCount > 0) {
            JPanel kiwiPanel = createBoughtProductPanel("Kiwi", "assets/images/kiwi.jpg", 1.25, kiwiCount);
            productContainer.add(kiwiPanel, new GridLayout(rows,cols));
            rows += 1;
        }
        if (mangoCount > 0) {
            JPanel mangoPanel = createBoughtProductPanel("Mango", "assets/images/mango.jpg", 2.25, mangoCount);
            productContainer.add(mangoPanel, new GridLayout(rows,cols));
            rows += 1;
        }

        // Making a Final Shopping Cart Total JLabel
        JLabel total = new JLabel(String.format("Final Shopping Cart Total: $%.2f", subtotal), SwingConstants.CENTER);
        productContainer.add(total, new GridLayout(rows,cols));

        // Making a Confirm Purchase button
        rows += 1;
        JButton checkoutBtn = new JButton("Confirm Purchase");
        productContainer.add(checkoutBtn, new GridLayout(rows,cols));

        JScrollPane productContainerScroll = new JScrollPane();
        productContainerScroll.setViewportView(productContainer);
        frame.add(productContainerScroll);
        frame.pack();
        frame.setVisible(true);
    }
}
