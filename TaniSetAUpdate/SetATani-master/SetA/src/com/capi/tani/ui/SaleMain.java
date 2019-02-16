package com.capi.tani.ui;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capi.tani.bean.Sales;
import com.capi.tani.dao.SaleDeo;
import com.capi.tani.dao.SaleDeoImpl;
import com.capi.tani.exception.ProductNameIsNumeric;
import com.capi.tani.service.SaleService;
import com.capi.tani.service.SaleServiceImpl;

public class SaleMain {

	public static void main(String[] args) throws ProductNameIsNumeric {
		// TODO Auto-generated method stub

		SaleDeo sd = new SaleDeoImpl();
		SaleService ss = new SaleServiceImpl(sd);
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			int saleId = (int) (Math.random() * 1000);
			System.out.println("Enter Product Code");
			int prodCode = sc.nextInt();
			if (ss.validateProductCode(prodCode)) {

			} else {
				System.out.println("Invalid Code");
				break;
			}
			System.out.println("Enter Product Category");
			String category = sc.next();
			if (ss.validateProductCat(category)) {

			} else {
				System.out.println("Invalid Category");
				break;
			}
			System.out.println("Enter Product Name");
			String prodName = sc.next();
			if (ss.validateProductName(prodName, category)) {

			} else {
				System.out.println("Invalid Name");
				break;
			}
			System.out.println("Enter Product Price");
			int price = sc.nextInt();
			if (ss.validateProductPrice(price)) {

			} else {
				System.out.println("Invalid price");
				break;
			}
			System.out.println("Enter Product Quantity");
			int quantity = sc.nextInt();
			if (ss.validateQuantity(quantity)) {

			} else {
				System.out.println("Invalid quantity");
				break;
			}
			float lineTotal = quantity * price;
			Sales sale = new Sales();
			sale.setCategory(category);
			sale.setProdCode(prodCode);
			sale.setProdName(prodName);
			sale.setQuantity(quantity);
			sale.setSaleId(saleId);
			sale.setSaleDate(LocalDate.now());
			sale.setLineTotal(lineTotal);
			sale.setPrice(price);
			System.out.println();
			HashMap<Integer, Sales> saleM = ss.insertSaleDetails(sale);

			System.out.println("Quantity:" + sale.getQuantity());
			System.out.println("Line Total: " + sale.getLineTotal());
			System.out.println();

			Iterator<Integer> iterator = saleM.keySet().iterator();
			while (iterator.hasNext()) { // iterate over sales hashmap to print

				System.out.print("Sales ID: ");
				int id = iterator.next();
				System.out.println(id);
				System.out.println(saleM.get(id));
			}

			break;
		case 2:sc.close();
			System.exit(0);
			break;
		}
	}

}
