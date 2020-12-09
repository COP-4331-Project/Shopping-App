package com.finalproject.group11.view;

import javax.swing.*;
import java.io.*;


/**
 * GUI acts as the main entry point for the shopping application.
 * The shopping app starts with login panel.
 * After the user logs in, the SellerView or ProductView will be displayed depending on user's role.
 * @author Ross Parsons
 * */

public class GUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        JFrame frame = new JFrame("Shopping App");

        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        LoginView loginPanel = new LoginView();
        frame.getContentPane().add(loginPanel);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
