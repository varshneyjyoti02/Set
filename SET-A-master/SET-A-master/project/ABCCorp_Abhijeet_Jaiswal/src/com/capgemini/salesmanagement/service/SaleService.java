package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sales;
import com.capgemini.salesmangement.dao.ISaleDao;

public class SaleService implements ISaleService {

	ISaleDao iSaleDao;		// creating reference to dao layer
	
	public SaleService(ISaleDao iSaleDao) {
		super();
		this.iSaleDao = iSaleDao;
	}

	@Override
	public HashMap<Integer, Sales> insertSaleDetails(Sales sales)  {		//method to call dao layer reference to store sales details into database
		HashMap<Integer,Sales> sale=iSaleDao.insertSaleDetails(sales);
		return sale;
	}

	@Override
	public boolean validateProductCode(int productId) {				// method to check for valid product id
		
		if(productId==1001||productId==1002||productId==1003||productId==1004)
			return true;
		return false;
	}

	@Override
	public boolean validateQuantity(int quantity) {					// method to check for valid quantity
		if(quantity>0&&quantity<5)
			return true;
		
		return false;
	}

	@Override
	public boolean validateProductCategory(String productCategory) {		// method to check for valid product category
		if(productCategory.equals("Electronics")||productCategory.endsWith("Toys"))
			return true;
		return false;
	}

	@Override
	public boolean validateProductName(String productName, int choice) {			//method to check for valid product name
		
		if((choice==1&&productName.equals("TV")||productName.equals("Smart phone")||productName.equals("Video Game"))||(choice==2&&productName.equals("Soft Toys")||productName.equals("Telescope")||productName.equals("Barbee Doll")))
			return true;
		return false;
	}

	@Override
	public boolean validateProductPrice(float price) {			// method to check for valid price
		if(price>200)
			return true;
		return false;
	}

}
