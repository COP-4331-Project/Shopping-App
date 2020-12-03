package com.finalproject.group11.users;

import com.finalproject.group11.model.Cart;
import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;

import java.io.*;
import java.util.ArrayList;

public class Placeholder {

    public static void init() throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Ross", "hello", new Cart(), 100.00));
        customers.add(new Customer(2, "James", "secret", new Cart(), 75.00));
        customers.add(new Customer(3, "Robert", "12345", new Cart(), 50.00));

        ObjectOutputStream out_cust = new ObjectOutputStream(new FileOutputStream("customers.dat"));
        out_cust.writeObject(customers);
        out_cust.close();

        ObjectInputStream in_cust = new ObjectInputStream(new FileInputStream("customers.dat"));
        in_cust.readObject();
        in_cust.close();

        ArrayList<Seller> sellers = new ArrayList<>();
        sellers.add(new Seller(1, "Adam", "password"));
        sellers.add(new Seller(2, "Mary", "stub"));
        sellers.add(new Seller(3, "Susanne", "123"));

        ObjectOutputStream out_sellers = new ObjectOutputStream(new FileOutputStream("sellers.dat"));
        out_sellers.writeObject(sellers);
        out_sellers.close();

        ObjectInputStream in_sellers = new ObjectInputStream(new FileInputStream("sellers.dat"));
        in_sellers.readObject();
        in_sellers.close();
    }

}
