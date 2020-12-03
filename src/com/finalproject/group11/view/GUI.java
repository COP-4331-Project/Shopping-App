package com.finalproject.group11.view;

import com.finalproject.group11.model.Cart;
import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;

import javax.swing.*;
import java.io.*;

public class GUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        JFrame frame = new JFrame("Shopping App");

        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        LoginView loginPanel = new LoginView();
        frame.getContentPane().add(loginPanel);


        /**
         * Serialize and load hardcoded Customer objects
         * */
        Customer[] customers = new Customer[3];
        customers[0] = new Customer(1,"Ross", "hello", new Cart(), 100.00);
        customers[1] = new Customer(2, "James", "secret", new Cart(), 75.00);
        customers[2] = new Customer(3, "Robert", "12345", new Cart(), 50.00);
        ObjectOutputStream out_cus = new ObjectOutputStream(new FileOutputStream("customers.dat"));
        out_cus.writeObject(customers);
        out_cus.close();

        /**
         * Serialize and load hardcoded Seller objects
         * */
        Seller[] sellers = new Seller[3];
        sellers[0] = new Seller(1, "Adam", "password");
        sellers[1] = new Seller(2, "Mary", "stub");
        sellers[2] = new Seller(3, "Susanne", "123");
        ObjectOutputStream out_seller = new ObjectOutputStream(new FileOutputStream("sellers.dat"));
        out_seller.writeObject(sellers);
        out_seller.close();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
