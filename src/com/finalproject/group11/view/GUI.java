package com.finalproject.group11.view;

import com.finalproject.group11.model.Cart;
import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;
import com.finalproject.group11.users.Placeholder;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        JFrame frame = new JFrame("Shopping App");

        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        LoginView loginPanel = new LoginView();
        frame.getContentPane().add(loginPanel);

        Placeholder.init();

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
