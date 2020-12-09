/**
 * LoginView
 * the UI for user login for the Shopping App
 * @author Ross Parsons
 * */

package com.finalproject.group11.view;

import com.finalproject.group11.controller.LoginAuthenticate;
import com.finalproject.group11.users.UserDB;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;


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

                try {
                    if(LoginAuthenticate.passwordCheck(username, password) == "CUSTOMER")
                    {
                        // if user that logged in is a Customer, a dashboard of products is returned.
                        ProductView myPV = new ProductView(500, 500);

                        /* Create productPanels */
                        JPanel applePanel = myPV.createProductPanel("Apple","assets/images/apple.jpg", 1.99, 25, "Freshly Picked!", true);
                        JPanel orangePanel = myPV.createProductPanel("Orange","assets/images/orange.jpg", 1.49, 44, "Citrus Sweetness!", true);
                        JPanel bananaPanel = myPV.createProductPanel("Bananas","assets/images/bananas.jpg", 3.75, 12, "Ripe & Ready!", true);
                        JPanel kiwiPanel = myPV.createProductPanel("Kiwi","assets/images/kiwi.jpg", 1.25, 36, "Green Goodness!", true);
                        JPanel mangoPanel = myPV.createProductPanel("Mango","assets/images/mango.jpg", 2.25, 47, "Mango Madness!", true);

                        /* Add the productPanels to the productContainer */
                        myPV.setUPGUI(applePanel, orangePanel, bananaPanel, kiwiPanel, mangoPanel);

                        System.out.println("You are logged in as Customer.");


                        /* if user is a seller, the SellerView will be displayed */
                    }else if(LoginAuthenticate.passwordCheck(username, password) == "SELLER"){
                        System.out.println("You are logged in as a Seller.");
                        SellerView.setUpGui(udb.getSeller(username));

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
