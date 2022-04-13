package Emp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*; 

public class Employee {
	
	 private int empId;
	 private String empName;
	 private int empAge;
	 private Double empSalary;
	 
	 Scanner sc=new Scanner(System.in);
	 
	 public boolean Empl() throws IOException
	{
		 
		 try
		 {
		   System.out.print("Enter the Employee ID:");
		   empId=sc.nextInt();
		 }
		 catch(InputMismatchException e)
	     {
			System.out.println("ID contains only intergers... !");
			return false;
					
	     }
		 
		 try
		 {   
			 sc.nextLine();
			 System.out.print("Enter the Employee Name:");
		     empName=sc.nextLine();
		 }
		 catch(InputMismatchException e)
	     {
			System.out.println("Employee Name should contain only characters !");
			return false;
					
	     }
		 
		 try
		 {
			 System.out.print("Enter the Employee Age:");
			 empAge=sc.nextInt();
		 }
		 catch(InputMismatchException e)
	     {
			System.out.println("Age should be only Numeric...!");
			return false;
					
	     }
		 
		 try
		 {
				
				System.out.print("Enter the Employee Salary:");
				empSalary=sc.nextDouble();
		 }
		 catch(InputMismatchException e)
	     {
			System.out.println("Salary should be only Numeric...!");
			return false;
					
	     }
		 

		//     ///////////////////////is added to prevent the skipping;
		

		
		
		File fout = new File("./out.txt");
		FileOutputStream fos = new FileOutputStream(fout,true);
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	
			String str1=String.valueOf(empId);
			String str2=String.valueOf(empAge);
			String str3=String.valueOf(empSalary);
			
		    bw.write(str1);
		    bw.newLine();
		    bw.write(empName);
		    bw.newLine();
		    bw.write(str2);
		    bw.newLine();
		    bw.write(str3);
			bw.newLine();
			
			
		    bw.close();
		    
		    return true;
	
	}
	 
	public String getName()
	{
		return empName;
	}
	
	public void display() throws IOException 
	{     
		
		File fout = new File("./out.txt");
		FileInputStream fos = new FileInputStream(fout);
		BufferedReader br = new BufferedReader(new InputStreamReader(fos));
		
		int sn=1;
		String line;
		int count=0; 
		String sb="\0";
		
	 
		
		while((line=br.readLine())!=null)  
		{  
			count++;
			sb=sb+line+"           "; 
			
			if(count==4){
			sb=String.valueOf(sn)+"          "+sb;	
		    System.out.println(sb);
			count=0;
			sn++;
			sb="\0";
		    }
	   
		}  
		fos.close();
		
	}

}
