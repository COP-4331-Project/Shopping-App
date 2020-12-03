package com.finalproject.group11.model;

import java.io.Serializable;
import java.util.ArrayList;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cart implements Serializable {

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

    /**
     * @return products_list, an ArrayList
     * */
    public ArrayList<Product> getProductList() {
        return products_list;
    }


}
