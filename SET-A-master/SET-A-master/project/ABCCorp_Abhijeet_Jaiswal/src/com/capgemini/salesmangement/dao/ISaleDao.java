package com.capgemini.salesmangement.dao;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sales;

public interface ISaleDao {

	public HashMap<Integer, Sales> insertSaleDetails(Sales sale);
	
}
