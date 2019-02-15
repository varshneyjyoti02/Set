package com.caogemini.salesmanagement.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.salesmanagement.service.ISaleService;
import com.capgemini.salesmanagement.service.SaleService;
import com.capgemini.salesmangement.dao.ISaleDao;
import com.capgemini.salesmangement.dao.SaleDao;

public class SalesTesting {

	ISaleDao iSaleDao= new SaleDao();
	ISaleService iSaleService= new SaleService(iSaleDao); 
	
	
	/*	insertSalesDetails	
	 * 1. if invalid product code is passed system sould return false
	 * 2. if invalid quantity is passed, system should return false
	 * 3. if invalid product category is passed, system should return false
	 * 4. if invalid product name is passed, system should return false
	 * 5. if invalid price is passed, system should return false
	 */
	
	@Test
	public void whenInvalidProductCodeIsPassedSystemShouldReturnFalse() {
		
		assertEquals(false,iSaleService.validateProductCode(101));
		
	}
	
	@Test
	public void whenInvalidQuantityIsPassedSystemShouldReturnFalse() {
		assertEquals(false,iSaleService.validateQuantity(0));
	}
	
	@Test
	public void whenInvalidCategoryIsPassedSystemShouldReturnFalse() {
		
		assertEquals(false, iSaleService.validateProductCategory("Anything"));
		
	}
	
	@Test
	public void whenInvalidProductNameIsPassedSystemShouldReturnFalse() {
		
		assertEquals(false, iSaleService.validateProductName("Soft Toy",1));
		
	}
	
	@Test
	public void whenInvalidPriceIsPassedSystemShouldReturnFalse() {
		
		assertEquals(false, iSaleService.validateProductPrice(0));
			
	}
	
}
