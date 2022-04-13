package com.wipro.sales.main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.Administrator;
import coml.wipro.sales.dao.StockDao;


public class SalesApplication {
	
	
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int flag=0;
		
		  while(1!=2)
		  {
			System.out.println("MAIN MENU \n=========");
			System.out.println("1.Insert Stock");
			System.out.println("2.Delete Stock");
			System.out.println("3.Insert Sale");
			System.out.println("4.View Sales Report");
			System.out.println("5.View Specific Stock");
			System.out.println("6.Exit:");
			System.out.print("Enter your choice (1-5):");	
			int n=sc.nextInt();
			
			System.out.println("\n");
			
			switch(n)
			{
			    
			case 1:
			{ 
				System.out.println("Enter the Details for the Stock....");
				System.out.print("Product Name:");
				sc.nextLine();/////to Skip the Pointer to get whole line as  a input;
				String productName=sc.nextLine();	
				System.out.print("Quantity on Hand:");
				int quantityOnHand=sc.nextInt();
				System.out.print("Product Unit Price:");
				double  productUnitPrice=sc.nextDouble();
				System.out.print("Reorder level:");
				int reorderLevel =sc.nextInt();
			    
				Product prd=new Product();
				prd.setProductName(productName);
				prd.setQuantityOnHand(quantityOnHand);
				prd.setProductUnitPrice(productUnitPrice);
				prd.setReorderLevel(reorderLevel);
				
			///	System.out.println(StockDao.generateProductID(productName));
			/////return the product id on successfulll;
				System.out.println( Administrator.insertStock(prd));
				System.out.println("\n");

			
				break;
			}    
			case 2:
			{
			  System.out.print("Enter the Product ID:");
			  String ProductID=sc.next();
			  
			 if(StockDao.getStock(ProductID)==null)
			 {
				  System.out.println("Wrong Product ID...\n");
		     }
			  else
			  {
				  System.out.println(Administrator.deleteStock(ProductID));
			  }
			  
			  break;
			}
			
			case 3:
			{     System.out.println("Enter the following Details.....");
				  System.out.print("Enter the Product ID:");
				  String productID=sc.next();
				  System.out.print("Enter the Quantity:");
				  int quantitySold=sc.nextInt();
				  System.out.print("Sales price per Unit:");
				  double salesPricePerUnit=sc.nextDouble();
				  //System.out.print("Enter the Date:");
				  //System.out.println(); 
				  
				  long millis=System.currentTimeMillis();  /////////////////generating current date;
				  java.sql.Date date=new java.sql.Date(millis); 
				  
				  //System.out.println(date);  
				  //java.util.Date date=new java.util.Date(); 
				  //System.out.println(date); 
				  
				  Sales sls=new Sales();//////////////creating object of sales class;
				  sls.setProductID(productID);
				  sls.setQuantitySold(quantitySold);
				  sls.setSalesPricePerUnit(salesPricePerUnit);
				  sls.setSalesData(date);
				  
				  System.out.println( Administrator.insertSales(sls));
				  System.out.println("\n");
			      //System.out.println("Stock Added Successfullly !! \n");
				  
  
				break;
				
			}
			case 4:
			{
				   
				ArrayList<SalesReport> array=new ArrayList<SalesReport>();
				array=Administrator.getSalesReport();
				
				Iterator<SalesReport> iter = array.iterator();
				
				System.out.println("\nSales Report:");
				System.out.println("=============================================================="
						+ "===================================================");
				
				System.out.format("%-10s  %-15s  %-12s  %-15s  %-12s %-15s %-15s %-10s ","Sales",
						"Sales","Product","Product","Quantity","Product",
						"Sales","Profit |");
				System.out.print("\n");
				System.out.format("%-10s  %-15s  %-12s  %-15s  %-12s %-15s %-15s %-10s ","ID",
						"Date","ID","Name","Sold","Unit Price",
						"Unit Price","Amount |");
				System.out.println("\n=============================================================="
						+ "===================================================");
				for(SalesReport x : array)
				{
					 System.out.format("%-10s  %-15s  %-12s  %-15s  %-12s %-15s %-15s %-10s ",x.getSalesID(),
								x.getSalesData(),x.getProductID(),x.getProductName(),x.getQuantitySold(),x.getProductUnitPrice(),
								x.getSalesPricePerUnit(),x.getProfitAmount());
						System.out.print("\n--------------------------------------------------------------"
								+ "---------------------------------------------------");
				
					 System.out.println("\n");
					
				}	
				
	
				System.out.println("\n");
				break;
			}
			
			case 5:
			{
				  System.out.print("Enter the Product ID:");
				  String productID=sc.next();
				  
   Product  prd =StockDao.getStock(productID);
   System.out.println("====================================================================");
   System.out.format("%-10s  %-15s  %-12s  %-15s %-15s","Product" ,"Product","Quantity ","Product","Reorder |");
   System.out.print("\n");
   System.out.format("%-10s  %-15s  %-12s  %-15s %-15s","Id" ,"Name","On-Hand","Unit-Price","Level   |");
   System.out.println("\n====================================================================");
				  
			 System.out.format("%-10s  %-15s  %-12s  %-15s  %-15s ",prd.getProductID(),
		prd.getProductName(),prd.getQuantityOnHand(),prd.getProductUnitPrice(),prd.getReorderLevel());
			 
	    System.out.println("\n--------------------------------------------------------------------\n");
		
			 
				break;
				
				
			}
		
			
			case 6:  
			{	
				flag=1;
				break;
			}
			
			 default:  System.out.println("Enter the correct choice...");
			 
			}
			
			if(flag==1)
			{
				System.out.println("Exciting..!! Thanks for using the Application.");
				break;
			}
			
		  }
		  
	}

	
	  
	}
	
	

	
	


