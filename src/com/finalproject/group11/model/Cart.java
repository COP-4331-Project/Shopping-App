package com.finalproject.group11.model;

import java.util.ArrayList;
<<<<<<< HEAD

public class Cart {


    // --- stub method ---
    public ArrayList<Product> getProductList(){return null;}

=======
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cart {

    // Member Variables
    private int id;
    private int seller_id;
    private ArrayList<Product> products_list;
    private DateTimeFormatter formatter;
    private LocalDateTime timestamp;

    // Cart Constructor
    public Cart() {
        products_list = new ArrayList<Product>();
    }

    // Cart Method
    public void add_product(Product product){
        this.products_list.add(product);
    }
>>>>>>> ba4337a94f3af33bcf9021b89ddb78f101124d47
}
