package com.eestienergia.BakeSaleManager;

public class BakeSaleModel {

	private int id;
	private String product;
	private int stock;
	private float price;
	private char prod;

	protected BakeSaleModel() {
	}

	protected BakeSaleModel(String product, int stock, float price, char prod) {
		this.product = product;
		this.stock = stock;
		this.price = price;
		this.prod = prod;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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
		return "BakeSale [id=" + id + ", product=" + product + ", stock=" + stock + ", price=" + price + "prod=" + prod + "]";
	}

}
