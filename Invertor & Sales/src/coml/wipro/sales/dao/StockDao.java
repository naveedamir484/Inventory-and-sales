package coml.wipro.sales.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DBUtil;

public class StockDao {

	public static void insertStock(Product sales)
	{
		//This method will put the object of sales having data into database; tbl_stock;
		  
		 try {
			  String quary="insert into tbl_stock values(?,?,?,?,?)";
			  Connection conn = DBUtil.getDBConnection();
		      PreparedStatement pstmt = conn.prepareStatement(quary);
	            pstmt.setString(1,sales.getProductID());
	            pstmt.setString(2,sales.getProductName());
	            pstmt.setInt(3,sales.getQuantityOnHand());
	            pstmt.setInt(4,(int) sales.getProductUnitPrice());
	            pstmt.setInt(5,sales.getReorderLevel());

	            pstmt.executeUpdate();
	            conn.close();
	         //   System.out.println("yooo !!! its done!");
	            
		 }
	        catch (Exception e)
		 {
	            System.out.println(e.getMessage());
	            
	     }
		
	}
	
	public static String generateProductID(String productName)
	{
		//this method will generate  the product id same as in previos method;
		String quary= "select SEQ_PRODUCT_ID.NEXTVAL from  DUAL";
		int SEQ_PRODUCT_ID = 0;

		try {
			Connection conn=DBUtil.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(quary);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				 SEQ_PRODUCT_ID = rs.getInt(1);
			
			conn.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		   String substr2 = productName.substring(0,2)+String.valueOf( SEQ_PRODUCT_ID);
		   return substr2;
		
	}
	
	public static void updateStock(String productID,int soldQty)
	{
		//this method update the stock table as itemsold ,,,them remain qty has to be reduced;
		int currentQuantity=0;
		
		try
    	{
    		String quary=" select * from  tbl_stock";
            Connection con=DBUtil.getDBConnection();
        	Statement st=con.createStatement(); 
    		ResultSet rs=st.executeQuery(quary);
    		
    		while(rs.next()){
    			
    			 if(rs.getString(1).equals(productID)){
    			 currentQuantity=rs.getInt(3);
    			 con.close();
    			 break;
    			 }
             }
    		
    		//System.out.println("itna  he bacha hi :"+currentQuantity);
    	 
    	}
    	catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    	}
		
		///////////////////////////////////////////now updating the quantit;
		
		try
    	{
			int leftQuantity=currentQuantity-soldQty;
    		String quary=" update tbl_stock set quantity_on_hand=? where product_id=?";
            Connection con=DBUtil.getDBConnection();
    		PreparedStatement pstmt = con.prepareStatement(quary);
            pstmt.setInt(1,leftQuantity);
            pstmt.setString(2,productID);
            pstmt.executeUpdate();	
            con.close();
    	 
    	}
    	catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    	}	
		
		
	}
	public static Product getStock(String productID)
	{
		//it will read db and from the object of stock using product ID;
		
		Product obj=new Product();

		try 
    	{
    		String quary="select * from tbl_stock ";
            Connection con=DBUtil.getDBConnection();
        	Statement st=con.createStatement(); 
            //PreparedStatement pstmt = con.prepareStatement(quary);
            //pstmt.setString(1, productID);
    		ResultSet rs=st.executeQuery(quary);
    		
    		while(rs.next())  
    		{
    			//System.out.println("yes positive!"+rs.getString(1));
    			//System.out.println("yes positive!3333 "+rs.getString(1));
    			if(rs.getString(1).equals(productID))
    		    {
    				obj.setProductID(rs.getString(1));
        			obj.setProductName(rs.getString(2));
        			obj.setQuantityOnHand(rs.getInt(3));
        			obj.setProductUnitPrice(rs.getInt(4));
        			obj.setReorderLevel(rs.getInt(5));
        			con.close();
        			return obj;
    		    }	
    	   }
          con.close();
    		
    	}
    	catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    	}
		
			
		return null;
	}
	public static void deleteStock(String productID)
	{
		//this method is used to delete the stock record using product id;
		
		try
    	{   
			String quary1="Delete from tbl_sales where product_id=?";
    		String quary2=" Delete from  tbl_stock where product_id=?";
            
    		Connection con=DBUtil.getDBConnection();
            PreparedStatement pstmt = con.prepareStatement(quary1);
            pstmt.setString(1,productID);
            pstmt.executeUpdate();	
      
            pstmt = con.prepareStatement(quary2);
            pstmt.setString(1,productID);
            pstmt.executeUpdate();	  
            con.close();
            
 
    	}
    	catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    	}	
		
		
		
	}
	
	
	
}
