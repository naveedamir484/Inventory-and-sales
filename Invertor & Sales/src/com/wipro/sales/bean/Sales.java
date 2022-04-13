package com.wipro.sales.bean;

public class Sales {
	
	String salesID;
	java.util.Date salesData;
	String productID;
	int quantitySold;
	double salesPricePerUnit;
	
	   
	public String getSalesID() {
		return salesID;
	}
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	
	/////////////////////////////////////////
	public java.util.Date getSalesData() {
		return salesData;
	}
	public void setSalesData(java.util.Date salesData) {
		this.salesData = salesData;
	}
	
	/////////////////////////////////////////////
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	////////////////////////////////////////////
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	//////////////////////////////////////////////
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}

	
}
