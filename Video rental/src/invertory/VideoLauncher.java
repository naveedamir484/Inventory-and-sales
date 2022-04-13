package invertory;
import java.util.Scanner;

public class VideoLauncher {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int flag=0;
	
		
		 VideoStore vs=new VideoStore();
		
		
		  while(1!=2)
		  {
			System.out.println("MAIN MENU \n=========");
			System.out.println("1.Add Videos:");
			System.out.println("2.Check Out Video:");
			System.out.println("3.Return Video:");
			System.out.println("4.Recieve Rating:");
			System.out.println("5.List Inventory:");
			System.out.println("6.Exit:");
			System.out.print("Enter your choice (1-6):");
			
			int n=sc.nextInt();
			
			switch(n)
			{
			    
			case 1:
			{ 
				System.out.print("Enter the name of Video you want to Add:");
			    String name=sc.next();
			    
			    vs.addVideo(name);
		
				break;
			}    
			case 2:
			{
			  System.out.print("Enter the name of video you want to checkout:");
			  String name=sc.next();
			  
			  vs.doCheckout(name);
			  
			  break;
			}
			case 3:
			{
				System.out.print("Enter the name of video you want to Return:");
				String name=sc.next();
				
				vs.doReturn (name);
				
				break;
				
			}
			case 4:
			{
				System.out.print("Enter the name of Video you want to Rate:");
				String name=sc.next();
				System.out.print("Enter the rating for this Video:");
				int rating=sc.nextInt();
				
				vs.receiveRating(name,rating);
				
				break;
			}
			case 5:
			{
				 System.out.println("The Inventory List is :");
				 System.out.println("--------------------------------------------------------");
				 System.out.println("Video Names    |      Checkout Status       |  Rating  |");
				 System.out.println("--------------------------------------------------------");
				 vs.listInventory();
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
