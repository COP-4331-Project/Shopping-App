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


        /* load Customer data */
        ObjectInputStream in_cus = new ObjectInputStream(new FileInputStream("customers.dat"));
        Customer[] customers1 = (Customer[]) in_cus.readObject();
        in_cus.close();

        Seller[] sellers = new Seller[3];
        sellers[0] = new Seller(1, "Adam", "password");
        sellers[1] = new Seller(2, "Mary", "stub");
        sellers[2] = new Seller(3, "Susanne", "123");


        ObjectOutputStream out_seller = new ObjectOutputStream(new FileOutputStream("sellers.dat"));
        out_seller.writeObject(sellers);
        out_seller.close();

        /* load Seller data */
        ObjectInputStream in_seller = new ObjectInputStream(new FileInputStream("sellers.dat"));
        Seller[] sellers1 = (Seller[]) in_seller.readObject();
        in_seller.close();



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
