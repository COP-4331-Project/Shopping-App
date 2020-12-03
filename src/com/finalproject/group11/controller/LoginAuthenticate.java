package com.finalproject.group11.controller;

import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoginAuthenticate {

    public static String passwordCheck(String username, char[] password) throws IOException, ClassNotFoundException {

        // Load Serialized Customer data
        ObjectInputStream in_cus = new ObjectInputStream(new FileInputStream("customers.dat"));
        ArrayList<Customer> customers = (ArrayList<Customer>) in_cus.readObject();
        in_cus.close();


        /* Load Serialized Seller data */
        ObjectInputStream in_seller = new ObjectInputStream(new FileInputStream("sellers.dat"));
        ArrayList<Seller> sellers = (ArrayList<Seller>) in_seller.readObject();
        in_seller.close();

        // Check if user is a customer
        String p = new String(password);
        for(Customer c: customers)
        {
            if(username.equals(c.getUsername()) && p.equals(c.getPassword())) return c.getRole();
        }


        for(Seller s: sellers)
        {
            if(username.equals(s.getUsername()) && p.equals(s.getPassword())) return s.getRole();
        }

        // User is neither Customer or Seller
        return null;
    }
}
