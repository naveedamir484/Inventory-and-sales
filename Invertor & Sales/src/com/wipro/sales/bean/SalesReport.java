package com.wipro.sales.bean;

public class SalesReport {

	  String SalesID;
	  java.util.Date SalesData;
	  String productID;
	  String productName;
	  int quantitySold;
	  double productUnitPrice;
	  double salesPricePerUnit;
	  double profitAmount;
	  
	  
	/////////////////////////////////////////
	  public String getSalesID() {
		return SalesID;
	}
	public void setSalesID(String salesID) {
		SalesID = salesID;
	}
	
	///////////////////////////////////////////
	public java.util.Date getSalesData() {
		return SalesData;
	}
	public void setSalesData(java.util.Date string) {
		SalesData = string;
	}
	
	//////////////////////////////////////////
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	///////////////////////////////////////////
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	////////////////////////////////////////////
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	///////////////////////////////////////////
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	
	////////////////////////////////////////////
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
	
	////////////////////////////////////////////
	public double getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(double profitAmount) {
		this.profitAmount = profitAmount;
	}
	
	
	
	  
}
