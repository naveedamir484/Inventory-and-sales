package invertory;

public class VideoStore {
	   
	  Video [] st= new Video[20];
	   private static int count=0;
	       
	   
	public void addVideo(String name)
	{
		  st[count]=new Video(name);
		  count++;
		  System.out.println("Video "+name+" added Sucessfully \n");
		  
	}
	
	public void doCheckout(String name)
	{
		 int i=0;
		 for(i=0;i<count;i++) 
		 {
			 if(st[i].getName().equals(name))
			 {
				 st[i].doCheckout();
				 break;
			 }
		 }
		
		 
		 if(i==count)System.out.println("There is no such Video in Inventory list... \n ");
			 
		 
		 

	}
    
	public void doReturn (String name)
	{
		int i=0;
		 for(i=0;i<count;i++) 
		 {
			 if(st[i].getName().equals(name))
			 {
				 st[i].doReturn();
				 break;
			 }
		 }
		 
		 if(i==count) System.out.println("There is no such Video in Inventory list... \n ");
			 
		 
		

	}
	
	public void receiveRating(String name,int rating)
	{
		
		 int i=0;
		 for(i=0;i<count;i++) 
		 {
			 if(st[i].getName().equals(name))
			 {
				 st[i].receiveRating(rating);
				 break;
			 }
		 }
		 
		 if(i==count) System.out.println("There is no such Video in Inventory list... \n");
			 
		 
		
	
	}
	public void listInventory()
	{
		for(int i=0;i<count;i++)
		{
			String names=st[i].getName();
			boolean bbl=st[i].checkout;
	        int rrt=st[i].getRating();
			System.out.println(names+"                  "+ bbl+"                  " +rrt);
			
			
		} 
		
		System.out.print("\n");
		
		
	}
	
	
}
