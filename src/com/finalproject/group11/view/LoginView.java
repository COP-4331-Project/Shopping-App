package com.finalproject.group11.view;

import com.finalproject.group11.controller.LoginAuthenticate;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginView extends JPanel{

    private static JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public LoginView() {

        this.setPreferredSize(new Dimension(200, 400));
        usernameTextField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        this.setBorder(new LineBorder(Color.blue));


        this.add(usernameLabel);
        this.add(usernameTextField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);

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

                        // Create productPanels
                        JPanel applePanel = myPV.createProductPanel("Apple","assets/images/apple.jpg", 1.99, 25, "Freshly Picked!");
                        JPanel orangePanel = myPV.createProductPanel("Orange","assets/images/orange.jpg", 1.49, 44, "Citrus Sweetness!");
                        JPanel bananaPanel = myPV.createProductPanel("Bananas","assets/images/bananas.jpg", 3.75, 12, "Ripe & Ready!");
                        JPanel kiwiPanel = myPV.createProductPanel("Kiwi","assets/images/kiwi.jpg", 1.25, 36, "Green Goodness!");
                        JPanel mangoPanel = myPV.createProductPanel("Mango","assets/images/mango.jpg", 2.25, 47, "Mango Madness!");

                        // Add the productPanels to the productContainer
                        myPV.setUPGUI(applePanel, orangePanel, bananaPanel, kiwiPanel, mangoPanel);

                        System.out.println("You are logged in as Customer.");
                    }else if(LoginAuthenticate.passwordCheck(username, password) == "SELLER"){
                        System.out.println("You are logged in as a Seller.");
                    }


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }


                usernameTextField.setText("");
                passwordField.setText("");
            }
        });



    }
}
