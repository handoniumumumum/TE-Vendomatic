package com.techelevator;

public class Item {
	private String slot;
	private String name;
	private int price;
	private int stock;
	private int sales;
	
	public Item(String slot, String name, int price)
	{
		this.slot = slot;
		this.name = name;
		this.price = price;
		stock = 5;
		sales = 0;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	public void decrementStock()
	{
		if(stock>0)
			stock--;
	}
	public void incrementSales()
	{
		sales++;
	}
	public void resetSalesCounter()
	{
		sales = 0;
	}
	public int getSales()
	{
		return sales;
	}

	
}
