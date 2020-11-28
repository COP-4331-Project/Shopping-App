package com.finalproject.group11.view;

import javax.swing.*;

public class LoginView extends JPanel{

    private JTextField username;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public LoginView() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        username = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        this.add(usernameLabel);
        this.add(username);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
    }
}
