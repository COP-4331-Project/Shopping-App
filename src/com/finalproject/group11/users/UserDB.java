package com.finalproject.group11.users;

import com.finalproject.group11.model.Cart;
import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;

import java.io.IOException;
import java.util.ArrayList;

public class UserDB {

    private ArrayList<Customer> customers;
    private ArrayList<Seller> sellers;



    public UserDB() throws IOException {

        customers = new ArrayList<>();

        customers.add(new Customer(1, "Susan", "password", new Cart(), 100.00));
        customers.add(new Customer(2, "Adam", "password", new Cart(), 100.00));
        customers.add(new Customer(3, "Abby", "password", new Cart(), 100.00));
        customers.add(new Customer(4, "Sam", "password", new Cart(), 100.00));
        customers.add(new Customer(5, "John", "password", new Cart(), 100.00));

        sellers = new ArrayList<>();

        sellers.add(new Seller(1, "Matt", "password"));
        sellers.add(new Seller(2, "Bob", "password"));
        sellers.add(new Seller(3, "Ross", "password"));
        sellers.add(new Seller(4, "Mike", "password"));
        sellers.add(new Seller(5, "Thomas", "password"));
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

    public void addSeller(Seller seller)
    {
        sellers.add(seller);
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public void printCustomers(){
        for(Customer c: customers){
            System.out.println(c.getId() + " " + c.getUsername());
        }
    }

    public void printSellers(){
        for(Seller s: sellers){
            System.out.println(s.getId() + " " + s.getUsername());
        }
    }

    public Seller getSeller(String username){
        for(Seller s: sellers){
            if(s.getUsername().equals(username)){
                return s;
            }
        }
        return null;
    }
}
