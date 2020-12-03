package com.finalproject.group11.view;

import com.finalproject.group11.model.Cart;
import com.finalproject.group11.model.Customer;

import javax.swing.*;
import java.io.*;

public class GUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        JFrame frame = new JFrame("Shopping App");

        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);


        LoginView loginPanel = new LoginView();
        frame.getContentPane().add(loginPanel);


        Customer[] customers = new Customer[3];
        customers[0] = new Customer(1,"Ross", "hello", new Cart(), 100.00);
        customers[1] = new Customer(2, "James", "secret", new Cart(), 75.00);
        customers[2] = new Customer(3, "Robert", "12345", new Cart(), 50.00);
        ObjectOutputStream out_cus = new ObjectOutputStream(new FileOutputStream("customers.dat"));
        out_cus.writeObject(customers);
        out_cus.close();


        // ObjectInputStream in_cus = new ObjectInputStream(new FileInputStream("customers.dat"));
        // Customer[] customers1 = (Customer[]) in_cus.readObject();
        // in_cus.close();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
