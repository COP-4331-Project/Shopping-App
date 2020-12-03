package com.finalproject.group11.controller;

import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginAuthenticate {

    public static String passwordCheck(String username, char[] password) throws IOException, ClassNotFoundException {

        // Load Serialized Customer data
        ObjectInputStream in_cus = new ObjectInputStream(new FileInputStream("customers.dat"));
        Customer[] customers1 = (Customer[]) in_cus.readObject();
        in_cus.close();


        /* Load Serialized Seller data */
        ObjectInputStream in_seller = new ObjectInputStream(new FileInputStream("sellers.dat"));
        Seller[] sellers1 = (Seller[]) in_seller.readObject();
        in_seller.close();

        // Check if user is a customer
        String p = new String(password);
        for(Customer c: customers1)
        {
            if(username.equals(c.getUsername()) && p.equals(c.getPassword())) return c.getRole();
        }


        for(Seller s: sellers1)
        {
            if(username.equals(s.getUsername()) && p.equals(s.getPassword())) return s.getRole();
        }

        // User is neither Customer or Seller
        return null;
    }
}
