package com.eestienergia.BakeSaleManager;

import java.text.DecimalFormat;
import java.util.ArrayList;

public final class BakeSaleInventory {

	private ArrayList<BakeSaleModel> itemList = new ArrayList<BakeSaleModel>();
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public void addItem(BakeSaleModel item) {
		itemList.add(item);
	}

	public ArrayList<BakeSaleModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<BakeSaleModel> itemList) {
		this.itemList = itemList;
	}

	public void getItem(BakeSaleModel item) {
		System.out.println(item.toString());
	}
	
	public void getItemsFromList(ArrayList<BakeSaleModel> list) {
		if(list.isEmpty()) {
			System.out.println("[]");
		}
		else {
			for(BakeSaleModel item : list) {
				getItem(item);
			}
		}
	}
	
	public ArrayList<BakeSaleModel> getCheckedItemsList(String csv) {
		ArrayList<BakeSaleModel> itemsChecked = new ArrayList<BakeSaleModel>();
		for(BakeSaleModel item : itemList) {
			if(csv.indexOf(item.getProd()) >= 0) {
				itemsChecked.add(item);
			}
		}
		return itemsChecked;
	}
	
	public void getStockByItem(BakeSaleModel item) {
		System.out.println(item.getStock());
	}
	
	public void getStockByProd(char prod) {
		int quantity = 0;
		for(BakeSaleModel item : itemList) {
			if(prod == item.getProd())
				quantity = item.getStock();
		}
		System.out.println(quantity);
	}
	
	public String checkStock(String csv) {
		String msgStock = "Available";
		for(BakeSaleModel item : getCheckedItemsList(csv)) {
			if(item.getStock() == 0) {
				msgStock = "Not enough stock";
				break;
			}
		}
		return msgStock;
	}
	
	public double getOrderPrice(String csv) {
		double amountToPay = 0.0d;
		for(BakeSaleModel item : getCheckedItemsList(csv)) {
			amountToPay += item.getPrice();
		}
		return amountToPay;
	}
	
	public String checkPayment(double amountPaid, String csv) {
		String msgPayment = "Purchased";
		if(amountPaid < getOrderPrice(csv)) {
			msgPayment = "Not enough money";
		}
		return msgPayment;
	}
	
	public void decrementItem(BakeSaleModel item) {
		int decr = item.getStock() - 1;
		if(decr >= 0) {
			item.setStock(decr);
		}
	}
	
	public String getChange(String csv, double amountPaid) {
		double change = 0.0d;
		if(amountPaid >= getOrderPrice(csv)) {
			change = amountPaid - getOrderPrice(csv);
		}
		return df.format(change);
	}
}
