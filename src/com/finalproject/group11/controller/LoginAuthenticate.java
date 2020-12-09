/**
 * Login Authenticator
 * ensures user logging in is registered with the shopping app
 * */

package com.finalproject.group11.controller;

import com.finalproject.group11.model.Customer;
import com.finalproject.group11.model.Seller;
import com.finalproject.group11.users.UserDB;

import java.io.IOException;
import java.util.ArrayList;

public class LoginAuthenticate {

    public static String passwordCheck(String username, char[] password) throws IOException, ClassNotFoundException {
        UserDB udb = new UserDB();
        udb.printCustomers();
        // Load Serialized Customer data
        /**ObjectInputStream in_cus = new ObjectInputStream(new FileInputStream("customers.dat"));
        ArrayList<Customer> customers = (ArrayList<Customer>) in_cus.readObject();
        in_cus.close();*/


        /* Load Serialized Seller data */
        /**ObjectInputStream in_seller = new ObjectInputStream(new FileInputStream("sellers.dat"));
        ArrayList<Seller> sellers = (ArrayList<Seller>) in_seller.readObject();
        in_seller.close();*/

        ArrayList<Seller> sellers = udb.getSellers();
        ArrayList<Customer> customers = udb.getCustomers();

        // Check if user is a customer
        String p = new String(password);

        for(int i = 0; i < customers.size(); i++)
        {
            if(username.equals(customers.get(i).getUsername()) && p.equals(customers.get(i).getPassword())) {
                return customers.get(i).getRole();
            }
            if(customers.get(i) == null)
            {
                return null;
            }
        }


        for(int i = 0; i < sellers.size(); i++)
        {
            if(username.equals(sellers.get(i).getUsername()) && p.equals(sellers.get(i).getPassword())) {
                return sellers.get(i).getRole();
            }

            if(sellers.get(i) == null)
            {
                return null;
            }
        }
        // User is neither Customer or Seller
        return null;
    }
}
