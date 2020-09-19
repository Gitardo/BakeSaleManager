package com.eestienergia.BakeSaleManager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAKESALE")
public class BakeSaleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String product;
	private int stock;
	private double price;
	private char prod;

	public BakeSaleModel() {
	}

	public BakeSaleModel(String product, int stock, double price, char prod) {
		this.product = product;
		this.stock = stock;
		this.price = price;
		this.prod = prod;
	}

	public int getId() {
		return id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getProd() {
		return prod;
	}

	public void setProd(char prod) {
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "BakeSale [id=" + id + ", product=" + product + ", stock=" + stock + ", price=" + price + ", prod=" + prod + "]";
	}
}
