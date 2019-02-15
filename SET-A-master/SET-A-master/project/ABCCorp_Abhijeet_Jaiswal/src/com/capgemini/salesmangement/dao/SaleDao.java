package com.capgemini.salesmangement.dao;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sales;

public class SaleDao implements ISaleDao {
	
	public static HashMap<Integer,Sales> saleDetails= new HashMap<Integer, Sales>();		// sales collection database

	@Override
	public HashMap<Integer, Sales> insertSaleDetails(Sales sale) {		// method to store sales details into database
		
		saleDetails.put(sale.getSaleid(),sale);		//adding the currently sold item sales info in database
		
		return saleDetails;
	}

}
