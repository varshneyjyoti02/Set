package com.capgemini.salesmanagement.ui;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Sales;
import com.capgemini.salesmanagement.service.ISaleService;
import com.capgemini.salesmanagement.service.SaleService;
import com.capgemini.salesmangement.dao.ISaleDao;
import com.capgemini.salesmangement.dao.SaleDao;

public class Client {

	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		ISaleDao iSaleDao= new SaleDao();
		ISaleService iSaleService= new SaleService(iSaleDao);
			while(true) {					//infinite loop as this is billing software so it has only one job
			boolean check=true;	
			int choice = 0;
			
			System.out.println("Enter product code: ");
			int prodCode= sc.nextInt();	//input product code
			sc.nextLine();
			while(check) {
				if(iSaleService.validateProductCode(prodCode))	//checks if the entered product code is valid or not;
					check=false;								//if valid product code then ask for next input otherwise repeatedly ask for valid product code
				else {
					System.out.println("Please enter correct product code: ");
					prodCode=sc.nextInt();
						sc.nextLine();
					
				}	
			}
			check=true;
			System.out.println("Enter product quantity: ");
			int quantity= sc.nextInt();		//input product quantity
			sc.nextLine();
			while(check) {
				if(iSaleService.validateQuantity(quantity))		//checks if the entered product quantity is valid or not;
					check=false;								//if valid product quantity then ask for next input otherwise repeatedly ask for valid quantity
				else {
					System.out.println("Please enter correct product quantity: ");
					quantity=sc.nextInt();
					sc.nextLine();
					
					}	
				}
			check=true;
			System.out.println("Enter product category: ");
			String category= sc.nextLine();		//input category
			while(check) {
				if(iSaleService.validateProductCategory(category))	//checks if valid product category is passed or not;
					check=false;									//if valid product code then ask for next input otherwise repeatedly ask for valid product category
				else {
					System.out.println("Please enter correct product category: ");
					category=sc.nextLine();							
				}	
			}
			if(category.equals("Electronics"))
				choice=1;
			check= true;
			System.out.println("Enter product name: ");
			String productName= sc.nextLine();		//input product name
			while(check) {
				if(iSaleService.validateProductName(productName,choice))	// check if valid product name is passed according to chosen category or not;
					check=false;									//if valid product code then ask for next input otherwise repeatedly ask for valid product name
				else {
					System.out.println("Please enter correct product name: ");
					productName=sc.nextLine();							
				}	
			}
			check=true;
			System.out.println("Enter product price");
			int price= sc.nextInt();		//input product price
			while(check) {
				if(iSaleService.validateProductPrice(price))	// checks if valid price is passed or not
					check=false;								//if valid price then ask for next input otherwise repeatedly ask for valid price
				else {
					System.out.println("Please enter correct product price: ");
					price=sc.nextInt();
					sc.nextLine();
					
				}	
			}
			int saleid=(int) (Math.random()*1000);  // randomly generates a sales id
			
			check=true;
			Sales sales= new Sales();			// create a new sales object
			sales.setProductCode(prodCode);		//set product code
			sales.setProductName(productName);	// set product name
			sales.setPrice(price);				//set product price
			sales.setSaleid(saleid);			//set saleds id
			sales.setSaleDate(LocalDate.now());	// set sale date as current date
			sales.setQuantity(quantity);		// set quantity sold
			sales.setLineTotal(price*quantity);	// set line total as quantity*price
			
			HashMap<Integer,Sales> salesData = iSaleService.insertSaleDetails(sales);		// get the whole sales data
			System.out.println("Quantity:"+sales.getQuantity());
			System.out.println("Line Total: "+sales.getLineTotal());
			System.out.println();
			
			Iterator<Integer> iterator= salesData.keySet().iterator();
			while(iterator.hasNext()) {											//iterate over sales hashmap to print
				
				System.out.print("Sales ID: ");
				int id=iterator.next();
				
				System.out.println(id);
				System.out.println(salesData.get(id));
				
			}
			
			System.out.println();
			System.out.println();
			
		}
	
	}
}