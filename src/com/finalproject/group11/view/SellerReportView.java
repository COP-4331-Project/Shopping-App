package com.finalproject.group11.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.group11.model.SellerReport;

public class SellerReportView {

	private SellerReport sellerReport;
	
	/**
	 * Constructs a new SellerReportView object based on a SellerReport
	 * @param sellerReport the SellerReport to view
	 * @return SellerReportView with seller report
	 * @author Matthew Taylor
	 *  */
	public SellerReportView(SellerReport sellerReport) {
		this.sellerReport = sellerReport;
	}
	
	/**
	 * Returns a JButton with functionality to move back from current view to the parent view
	 * @param JPanel the panel to add the button to
	 * @param SellerView the view to return to once the button is pressed
	 * @return JButton to move back from current view
	 * @author Matthew Taylor
	 *  */
	private JButton createBackButton(JPanel panel, SellerView sellerView) {
		JButton backButton = new JButton("Back to inventory");
		backButton.addActionListener(
				new ActionListener() {
	        		public void actionPerformed(ActionEvent event) {
	        			panel.removeAll();
	        			panel.add(sellerView.displaySellerInventory());
	        			panel.revalidate();
	        			panel.repaint();
	        		}
				}
			);
		return backButton;
	}
	
	/**
	 * Returns a JPanel that displays the seller report
	 * @param SellerView the view to return to once the button is pressed
	 * @return JPanel with seller report displayed
	 * @author Matthew Taylor
	 *  */
	public JPanel createSellerReportPanel(SellerView sellerView) {
		JPanel sellerReportPanel = new JPanel();
		JButton backToInventoryButton = createBackButton(sellerReportPanel, sellerView);
		sellerReportPanel.add(backToInventoryButton);

		if (this.sellerReport.getProfit() == 0 && this.sellerReport.getRevenue() == 0 && 
				this.sellerReport.getSales() == 0) {
			JPanel noDataAvailablePanel = new JPanel();
			JLabel noDataAvailableLabel = new JLabel("No financial data available.");
			noDataAvailablePanel.add(noDataAvailableLabel);
			sellerReportPanel.add(noDataAvailablePanel);
		}
		else {
			JPanel dataAvailablePanel = new JPanel();
			JLabel dataAvailableLabel = new JLabel("Seller Report");
						
			JPanel profitPanel = new JPanel();
			JLabel profitLabel = new JLabel("Profit");
			JLabel profitAmountLabel = new JLabel(String.valueOf(this.sellerReport.getProfit()));
			profitPanel.add(profitLabel);
			profitPanel.add(profitAmountLabel);

			JPanel revenuePanel = new JPanel();
			JLabel revenueLabel = new JLabel("Revenue");
			JLabel revenueAmountLabel = new JLabel(String.valueOf(this.sellerReport.getRevenue()));
			revenuePanel.add(revenueLabel);
			revenuePanel.add(revenueAmountLabel);

			JPanel salesPanel = new JPanel();
			JLabel salesLabel = new JLabel("Sales");
			JLabel salesAmountLabel = new JLabel(String.valueOf(this.sellerReport.getSales()));
			salesPanel.add(salesLabel);
			salesPanel.add(salesAmountLabel);
			
			JPanel reportsPanel = new JPanel();
			reportsPanel.add(profitPanel);
			reportsPanel.add(revenuePanel);
			reportsPanel.add(salesPanel);
			
			dataAvailablePanel.add(dataAvailableLabel);
			sellerReportPanel.add(dataAvailablePanel);
			sellerReportPanel.add(reportsPanel);
		}
		return sellerReportPanel;
	}
} 
