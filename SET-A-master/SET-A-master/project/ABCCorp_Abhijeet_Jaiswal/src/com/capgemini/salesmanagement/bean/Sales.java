package com.capgemini.salesmanagement.bean;

import java.time.LocalDate;

public class Sales {

	@Override
	public String toString() {
		return "productCode=" + productCode + ", productName=" + productName
				+ ", saleDate=" + saleDate + ", price=" + price + ", quantity=" + quantity + ", lineTotal=" + lineTotal;
	}
	private int saleid;
	private int productCode;
	private String productName;
	private LocalDate saleDate;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int quantity;
	private float lineTotal;
	public int getSaleid() {
		return saleid;
	}
	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(float lineTotal) {
		this.lineTotal = lineTotal;
	}
	
	
	
}
