package com.finalproject.group11.users;

import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Users {

    ArrayList<Customer> customers;
    ArrayList<Seller> sellers;

    public Users() throws IOException, ClassNotFoundException {

        this.customers = new ArrayList<>();
        ObjectInputStream in_cust = new ObjectInputStream(new FileInputStream("customers.dat"));
        this.customers = (ArrayList<Customer>) in_cust.readObject();
        in_cust.close();

        this.sellers = new ArrayList<>();
        ObjectInputStream in_sellers = new ObjectInputStream(new FileInputStream("sellers.dat"));
        this.sellers = (ArrayList<Seller>) in_sellers.readObject();
        in_sellers.close();
    }


    // return number of customers registered with Shopping App
    public int getCustomerAmount(){
        return this.customers.size();
    }

    // return number of sellers registered with Shopping App
    public int getSellerAmount(){
        return this.sellers.size();
    }

    public void writeCustomer(Customer c) throws IOException {
        customers.add(c);
        ObjectOutputStream out_cust = new ObjectOutputStream(new FileOutputStream("customers.dat"));
        out_cust.writeObject(customers);
        out_cust.close();
    }
}
