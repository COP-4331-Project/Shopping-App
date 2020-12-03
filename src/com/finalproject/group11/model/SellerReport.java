package com.finalproject.group11.model;

import java.io.Serializable;

public class SellerReport implements Serializable {

    // SellerReport Member Variables
    private int seller_id;
    private double profit;
    private double revenue;
    private int sales;

    // SellerReport Constructor
    public SellerReport(int seller_id) {
        this.seller_id = seller_id;
        this.profit = 0;
        this.revenue = 0;
        this.sales = 0;
    }

    // SellerReport Methods
    public void update_seller_report() {
        // Update the profit, revenue, and sales every time items are sold
    }

    public void display_report() {
        // Save the current SellerReport values, make the SellerReport, and show it to the screen
    }
}
