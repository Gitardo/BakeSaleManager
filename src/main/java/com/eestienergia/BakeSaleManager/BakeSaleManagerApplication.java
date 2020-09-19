package com.eestienergia.BakeSaleManager;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BakeSaleManagerApplication extends BakeSaleModel {

	public static void main(String[] args) {
		
		BakeSaleModel brownie = new BakeSaleModel("Brownie", 48, 0.65d, 'B');
		BakeSaleModel muffin = new BakeSaleModel("Muffin", 36, 1.00d, 'M');
		BakeSaleModel cakepop = new BakeSaleModel("Cake pop", 24, 1.35d, 'C');
		BakeSaleModel water = new BakeSaleModel("Water", 30, 1.50d, 'W');
		
		BakeSaleInventory inventory = new BakeSaleInventory();
		ArrayList<BakeSaleModel> fullList = new ArrayList<BakeSaleModel>();
		fullList = inventory.getItemList();
		inventory.addItem(brownie);
		inventory.addItem(muffin);
		inventory.addItem(cakepop);
		inventory.addItem(water);

		String orderCSV = new String();
		double amountPaid;
		
		// Test1
//		Items to Purchase > B, C, W
//		Total > $3.50
//		Amount Paid > $4.00
//		Change > $0.50
		System.out.println("1============================================================================");
		orderCSV = "B, C, W";
		amountPaid = 4.0;
		inventory.getItemsFromList(fullList);
		orderAndPurchase(inventory, orderCSV, amountPaid);
		inventory.getItemsFromList(fullList);

		// Test2
//		Items to Purchase > B
//		Total > $0.65
//		Amount Paid > $0.75
//		Change > $0.10 
		System.out.println("2============================================================================");
		orderCSV = "B";
		amountPaid = 0.75;
		inventory.getItemsFromList(fullList);
		orderAndPurchase(inventory, orderCSV, amountPaid);
		inventory.getItemsFromList(fullList);

		// Test3
//		Items to Purchase > C,M
//		Total > $2.35
//		Amount Paid > $2.00
//		Change > Not enough money
		System.out.println("3============================================================================");
		orderCSV = "C,M";
		amountPaid = 2.0d;
		inventory.getItemsFromList(fullList);
		orderAndPurchase(inventory, orderCSV, amountPaid);
		inventory.getItemsFromList(fullList);

		// Test4
//		Items to Purchase > W
//		Total > Not enough stock 
		System.out.println("4============================================================================");
		water.setStock(0);
		orderCSV = "W";
		inventory.getItemsFromList(fullList);
		orderAndPurchase(inventory, orderCSV, amountPaid);
		inventory.getItemsFromList(fullList);

		System.out.println("SPRING=======================================================================");
		SpringApplication.run(BakeSaleManagerApplication.class, args);
	}
	
	public static String order(BakeSaleInventory inventory, String orderCSV) {
		String msgOrder = new String();

		msgOrder = inventory.checkStock(orderCSV);
		
		return msgOrder;
	}
	
	public static String purchase(BakeSaleInventory inventory, String orderCSV, double amountPaid) {
		String msgPurchase = new String();
		
		msgPurchase = inventory.checkPayment(amountPaid, orderCSV);
		
		return msgPurchase;
	}
	
	public static void orderAndPurchase(BakeSaleInventory inventory, String orderCSV, double amountPaid) {
		String msgOrder, msgPruchase, change;
		DecimalFormat df = new DecimalFormat("0.00");
		
		msgOrder = order(inventory, orderCSV);
		System.out.println(msgOrder);
		if(msgOrder == "Available") {
			double orderPrice = inventory.getOrderPrice(orderCSV);
			System.out.println(df.format(orderPrice));
			msgPruchase = purchase(inventory, orderCSV, amountPaid);
			System.out.println(msgPruchase);
			if(msgPruchase == "Purchased") {
				change = inventory.getChange(orderCSV, amountPaid);
				System.out.println(change);
				for(BakeSaleModel item : inventory.getCheckedItemsList(orderCSV)) {
					inventory.decrementItem(item);
				}
			}
		}
	}
}
