package com.finalproject.group11.controller;

import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginAuthenticate {
    public static boolean authenticate(String username, char[] password) {
        String p = new String(password);
        // hardcoded username and password
        return username.equals("bob") && p.equals("secret");
    }

    public static boolean passwordCheck(String username, char[] password) throws IOException, ClassNotFoundException {

        // Load Serialized customers
        ObjectInputStream in_cus = new ObjectInputStream(new FileInputStream("customers.dat"));
        Customer[] customers1 = (Customer[]) in_cus.readObject();
        in_cus.close();

        // Check if user is a customer
        String p = new String(password);
        for(Customer c: customers1)
        {
            if(username.equals(c.getUsername()) && p.equals(c.getPassword()))
            {
                System.out.println("You are a customer");
                return true;
            }
        }

        System.out.println("You are NOT a customer");
        return false;
    }
}
