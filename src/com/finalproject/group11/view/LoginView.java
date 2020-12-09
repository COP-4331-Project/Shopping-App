/**
 * LoginView
 * the UI for user login for the Shopping App
 * @author Ross Parsons
 * */

package com.finalproject.group11.view;

import com.finalproject.group11.controller.LoginAuthenticate;
import com.finalproject.group11.users.UserDB;
import com.finalproject.group11.model.Product;
import com.finalproject.group11.model.Seller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * LoginView subclasses JPanel
 * */
public class LoginView extends JPanel implements Serializable {

    private static JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private UserDB udb;
    private ImageIcon img;


    /**
     * Construct the LoginView
     * */
    public LoginView() throws IOException {

        this.udb = new UserDB();

        this.setPreferredSize(new Dimension(200, 400));

        usernameTextField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        this.setBorder(new LineBorder(Color.blue));

        /* Put shopping cart image on login screen */
        String imgPath = "assets/images/sc.jpg";
        img = new ImageIcon(imgPath);
        Image imgResize = img.getImage();
        Image newImg = imgResize.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newImg);

        this.add(usernameLabel);
        this.add(usernameTextField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
        this.add(registerButton);
        this.add(new JLabel(img));

        /**
         *
         * */
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                System.out.println(username);
                char[] password = passwordField.getPassword();
                System.out.println(password);
                
             // if user that logged in is a Customer, a dashboard of products is returned.
                ProductView myPV = new ProductView(500, 500);                
                
                String[] productImgs = {"assets/images/apple.jpg", "assets/images/orange.jpg", 
                                        "assets/images/bananas.jpg", "assets/images/kiwi.jpg", 
                                        "assets/images/mango.jpg"};
                
                Product apple = new Product(1, "Apple", 1.99, "Freshly Picked!", 25);
        		Product orange = new Product(2, "Orange", 1.49, "Citrus Sweetness!", 44);
        		Product banana = new Product(3, "Bananas", 3.75, "Ripe and Ready!!", 12);
        		Product kiwi = new Product(4, "Kiwi", 1.25, "Green Goodness!", 36);
        		Product mango = new Product(5, "Mango", 2.25, "Mango Madness!", 47);

                try {
                    if(LoginAuthenticate.passwordCheck(username, password) == "CUSTOMER")
                    {
                        /* Create productPanels */
                    	JPanel applePanel = myPV.createProductPanel(apple,"assets/images/apple.jpg", true);
                        JPanel orangePanel = myPV.createProductPanel(orange,"assets/images/orange.jpg", true);
                        JPanel bananaPanel = myPV.createProductPanel(banana,"assets/images/bananas.jpg", true);
                        JPanel kiwiPanel = myPV.createProductPanel(kiwi,"assets/images/kiwi.jpg", true);
                        JPanel mangoPanel = myPV.createProductPanel(mango,"assets/images/mango.jpg", true);

                        /* Add the productPanels to the productContainer */
                        myPV.setUPGUI(applePanel, orangePanel, bananaPanel, kiwiPanel, mangoPanel);

                        System.out.println("You are logged in as Customer.");


                        /* if user is a seller, the SellerView will be displayed */
                    }else if(LoginAuthenticate.passwordCheck(username, password) == "SELLER"){
                        System.out.println("You are logged in as a Seller.");
                        Seller seller = udb.getSeller(username);
                        
                        seller.add_product_to_sell(apple);
                		seller.add_product_to_sell(orange);
                		seller.add_product_to_sell(banana);
                		seller.add_product_to_sell(kiwi);
                		seller.add_product_to_sell(mango);
                        
                		SellerView.setUpGui(seller, productImgs);
                    }
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
                usernameTextField.setText("");
                passwordField.setText("");
            }
        });

        /***/
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register button pressed");
                RegisterView.setUpGui();
            }
        });
    }
}
