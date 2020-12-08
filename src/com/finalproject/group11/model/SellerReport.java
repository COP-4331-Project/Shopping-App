package com.finalproject.group11.model;

import java.io.Serializable;

public class SellerReport implements Serializable{

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

    public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	// SellerReport Methods
    public void update_seller_report() {
        // Update the profit, revenue, and sales every time items are sold
    }

    public void display_report() {
        // Save the current SellerReport values, make the SellerReport, and show it to the screen
    	
    }
}
