package com.peronal.loan.model;

import java.util.Scanner;

import com.peronal.loan.businesslogic.BusinessLogic1;
import com.peronal.loan.businesslogic.BusinessLogic2;
import com.peronal.loan.dbconnection.MySQLclass;
import com.peronal.loan.javabean.JavaBean;
import com.personal.loan.userdetails.Accept_Details;



public class First {
	
	public static void main(String[] args) throws Exception
    {
        BusinessLogic1 obj = new BusinessLogic1();
        BusinessLogic2 obj1 = new BusinessLogic2();
        JavaBean obj2 = new JavaBean();
        MySQLclass obj6 = new MySQLclass();
        Accept_Details ob = new Accept_Details();
        int press;
        
        Scanner sc = new Scanner(System.in);

        obj.welcomePage();
        System.out.println("Already a member press 1 else 2");
        press = sc.nextInt();
        
        if(press == 2)
       {
        
        ob.newUserDetails();
        
        
        obj.eligibility(obj2.getName(), obj2.getCity(), obj2.getPhonenumber(), obj2.getPan(),obj2.getSal(), obj2.getExpense());
             obj1.endMessage();
             
             obj6.insertDisplay();
             
             obj6.display();
        }
        
        
        else if(press == 1)
        {
        	ob.existingUserDetails();
        	
      
        	int b=obj6.validate(obj2.getUid(), obj2.getPwd());
        	
        	if(b==1)
        	{
        		System.out.println("Login successful");
        		
        		System.out.println("press the number for the following operations to be performed \n 1. Update Information \n 2. Drop information \n 3. To obtain Loan \n 4. To Display Information");
        		int num = sc.nextInt();
        		
        		if(num==3)
        		{
        		
                ob.loanChange();
               
                BusinessLogic2 obj8 = new BusinessLogic2();
                obj8.loanDetails(obj2.getLoanAmount(), obj2.getTenure());
                
                obj1.endMessage();
                
                obj6.insertDisplay();
                
                obj6.display();
        		}
        		
        		else if(num==4)
        		{
        			obj6.display();
        		}
        		else if(num ==2)
        		{
        			//obj6.deleteInfo();
        			System.out.println("Deleted your information");
        			System.out.println("Your account becomes inactive");
        		}
        		else
        		{
        			obj6.updateInfo();
        			obj6.insertUpdate();
        			obj6.display();
        		}
        	}
        	else
        	{
        		System.out.println("Invalid userId or password");
        	}
        }
        else
        {
      	System.out.println("Invalid option");
       }
      //  obj.eligibility(name,city,phNumber,pan,age,sal,expense);
        
    }
}