package com.finalproject.group11.view;

import com.finalproject.group11.controller.LoginAuthenticate;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                if (!LoginAuthenticate.authenticate(username, password)) {
                    System.out.println("Invalid username or password: please try again.");
                } else {
                    System.out.println("Logged in!");
                }
                // TODO: return new swing component that renders the catalogue of products if user is Customer
                // or return SellerReport if user is Seller
                usernameTextField.setText("");
                passwordField.setText("");
            }
        });



    }
}
