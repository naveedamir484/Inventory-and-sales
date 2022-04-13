package com.wipro.sales.service;
import java.util.ArrayList;
import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import coml.wipro.sales.dao.SalesDao;
import coml.wipro.sales.dao.StockDao;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Administrator {
        
	public static String insertStock(Product stockobj)
	{
		//condition will be checked;;;;if true than ////call insert Stock;
 
		if(stockobj==null)
		{
			return "Object Not valid for INSERTION!";
		}
		else if(stockobj.getProductName().length()<2)
		{
			return "Product Name should be of minimum two letter in Length!";
		}
		else
		{
			//generate the Product id and save it ;
			
			String id=StockDao.generateProductID(stockobj.getProductName());
			stockobj.setProductID(id);
			StockDao.insertStock(stockobj);
			System.out.println("Stock Added!");
			return "The Generated Product Id:"+id;
		}
		
		
	}
	
	
	
	 public static String deleteStock(String ProductID)
	{    
		// System.out.println("perfect till here");
		 StockDao.deleteStock(ProductID);
		 return "Stock Deleted!";
	}
	 
	 
	 
	public static String insertSales(Sales salesobj) throws ParseException/////////////////////
	{
		
				if(salesobj==null)
				{
					return "Object Not valid for INSERTION!";
				}
				else
				{
					
				   String id=salesobj.getProductID();
				   int qty=salesobj.getQuantitySold();
				   String Str=SalesDao.hasProductID(id,qty);
				   
				   
				   if(Str==null)
				   {
					   
					      long millis=System.currentTimeMillis();  
						  java.sql.Date date=new java.sql.Date(millis);  
						  String str=String.valueOf(date) ;
						      
						  
					        SimpleDateFormat sdfo= new SimpleDateFormat("yyyy-MM-dd");
					        Date d1 = sdfo.parse(str);//now;
					        Date d2 = sdfo.parse(String.valueOf(salesobj.getSalesData()));

					        if (d1.compareTo(d2) < 0)
					        {
					            return "Invalid Date!";
					        }
					        else
					        {
					        	
					             String iid=SalesDao.generateSalesID(salesobj.getSalesData());
								 salesobj.setSalesID(iid);
								 SalesDao.insertSales(salesobj);
								 
								 /////not update the table;
								 
								 StockDao.updateStock(salesobj.getProductID(),salesobj.getQuantitySold());
								// System.out.println("Sales Completed...");
								 return "Sales Completed...";
								 
	
					        }
					
				   }
				   
					//generate the Product id and save it ;
				  
					
					
				}
				return null;
				
		
			
	}
	
  public static ArrayList<SalesReport> getSalesReport() throws Exception 
	{ 
	  
		return SalesDao.getSalesReport();
	}
	
}
