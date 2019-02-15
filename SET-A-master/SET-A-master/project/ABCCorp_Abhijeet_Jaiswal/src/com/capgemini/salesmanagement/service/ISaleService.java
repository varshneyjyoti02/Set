package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sales;

public interface ISaleService {

	public HashMap<Integer,Sales> insertSaleDetails(Sales sales);
	public boolean validateProductCode(int productId);
	public boolean validateQuantity(int quantity);
	public boolean validateProductCategory(String productCategory);
	public boolean validateProductName(String productName, int choice);
	public boolean validateProductPrice(float price);
	
}
