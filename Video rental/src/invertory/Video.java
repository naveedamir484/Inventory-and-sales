package invertory;
import java.util.Scanner;

public class Video {
	
	   private String videoName;
	   public boolean checkout=true;    
	   private int rating;
	   
	   
	   public String getName() {

		   return videoName;
	   }
	   
	   public void doCheckout() 
	   {
		  checkout=false;
	      System.out.println( "Video "+videoName+" checked out Sucessfully \n"); 
	   }
	   
	    public void doReturn() {
	    	
	    	checkout=true;
	    	System.out.println("your "+ videoName +" returned Sucessfully \n");
		   
	   }
	   
	    public void receiveRating(int rating) {
	    	
	       this.rating=rating;
	        System.out.println("Rating "+ rating +" has been Mapped to the Video "+videoName+". \n");
		   
	   } 
	    
	    public  int getRating()
	    {
	    	 return rating;
	    }
	   
	    
	    Video (String name)
	    {
	    	   this.videoName=name;
	    }
	   
	   
	
}
 