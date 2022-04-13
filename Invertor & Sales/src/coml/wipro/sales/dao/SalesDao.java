package coml.wipro.sales.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;



public class SalesDao {
		
   public static  void insertSales(Sales sales)
    {
    	// insert sales object into sales table in db;
	   try {
			  String quary="insert into tbl_sales values(?,?,?,?,?)";
			  Connection conn = DBUtil.getDBConnection();
		      PreparedStatement pstmt = conn.prepareStatement(quary);
	            pstmt.setString(1,sales.getSalesID());
	            pstmt.setDate(2,(Date) sales.getSalesData());
	            pstmt.setString(3,sales.getProductID());
	            pstmt.setInt(4,(int) sales.getQuantitySold());
	            pstmt.setInt(5,(int) sales.getSalesPricePerUnit());
	            pstmt.executeUpdate();
	            conn.close();
	            //System.out.println("yooo !!! its done!");
	            
		 }
	        catch (Exception e)
		 {
	            System.out.println(e.getMessage());
	            
	     }
		 
    }
    public static String generateSalesID(java.util.Date salesDate)
    {
    	//this is used to generate the sales id;
    	
    	String quary= "select SEQ_SALES_ID.NEXTVAL from  DUAL";
		int SEQ_SALES_ID = 0;

		try {
			Connection conn=DBUtil.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(quary);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				 SEQ_SALES_ID = rs.getInt(1);
			
			conn.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		   
		   String strDate=String.valueOf(salesDate);
		   String substr2 = String.valueOf( SEQ_SALES_ID)+strDate.substring(2,4);
		   return substr2;
	
    }
    
    
    
    public static String hasProductID(String ProductID ,int quantity)/////my function
    {
    	try
    	{
    		int i=0;
    		int q=0;
    		String quary="select * from  tbl_stock";
            Connection con=DBUtil.getDBConnection();
        	Statement st=con.createStatement(); 
    		ResultSet rs=st.executeQuery(quary);
    		
    		while(rs.next())  
    		{
    			String prdId=rs.getString(1);
    			int stockQty=rs.getInt(3);
    			
    			if(prdId.equals(ProductID))
    			{
    			  i=1;
    			  if(stockQty>=quantity)
    			  {
    				  q=1;
    				  con.close();
    				  break;
    			  }  
    			}
 
    	     }
    		
    		if(i==1 && q==1)return null;
    		if(i==1 && q==0)return "Not Enough Stock On Hand for Sales!";	
    		else if(i==0 && q==0)return "Unknown Product for Sales!";
    	
    	   con.close();
    	}
    	catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    	}
		return "Error!";

    	
    }
    
    public static ArrayList<SalesReport> getSalesReport() {
    	
    	// it runs v_sales_report  view 
    	// and add all data into salesreport object
    	// then form the array of such object and then return;
    	
    	ArrayList<SalesReport> sp=new ArrayList<SalesReport>();
    
    	try 
    	{
    		String quary="select * from V_Sales_Report";
            Connection con=DBUtil.getDBConnection();
        	Statement st=con.createStatement(); 
    		ResultSet rs=st.executeQuery(quary);
    		
    		while(rs.next())  
    		{
    			SalesReport  srep=new SalesReport();
    			
    			srep.setProductID(rs.getString(3));
    			srep.setProductName(rs.getString(4));
    			srep.setProductUnitPrice(rs.getInt(6));
    			srep.setProfitAmount(rs.getInt(8));
    			srep.setQuantitySold(rs.getInt(5));
    			srep.setSalesData(rs.getDate(2));
    			srep.setSalesID(rs.getString(1));
    			srep.setSalesPricePerUnit(rs.getInt(7));
    	        sp.add(srep);  
    	        
    	        
    	   }
    		con.close();
    		
    	}
    	catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    	}
		
		
        return sp;
    }
    
    
}
