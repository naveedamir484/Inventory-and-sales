package Emp;
import java.io.IOException;
import java.util.Scanner;

public class Mainfn {

	public static void main(String[] args) throws IOException {
		    
		Scanner sc=new Scanner(System.in);
		int flag=0;
		
		  while(1!=2)
		  {
			System.out.println("MAIN MENU \n---------");
			System.out.println("1.Add an Employee");
			System.out.println("2.Display All Employee Info.");
			System.out.println("3.Exit the Application\n");
			System.out.print("Enter your option (1-3): ");
			
			int n=sc.nextInt();
			
	        switch(n)
	        {
		    
			case 1:
			{ 
				Employee em=new Employee();
				if(em.Empl())
				System.out.println(em.getName()+" Employee is Added Sucessfully! \n");
				else System.out.println("Try Again \n!");
				break;
				
				
			}    
			case 2:
			{
			   Employee em=new Employee();
			     System.out.println("The List of Employees (Report):"+ "");
				 System.out.println("--------------------------------------------------------------------");
				 System.out.println(" S.no  |     Id     |        Name        |     Age    |   Salary   |            ");
				 System.out.println("--------------------------------------------------------------------");
				 em.display();
				 System.out.println("\n");
                 break;
			}

			case 3:      {flag=1;  break;}
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
