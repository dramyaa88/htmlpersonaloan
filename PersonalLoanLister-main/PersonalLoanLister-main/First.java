import java.util.Scanner;



public class First extends BusinessLogic1{
	
	public static void main(String[] args) throws Exception
    {
        BusinessLogic1 obj = new BusinessLogic1();
        JavaBean obj2 = new JavaBean();
        MySQLclass obj6 = new MySQLclass();
        Accept_Details ob = new Accept_Details();
        
        Scanner sc = new Scanner(System.in);

        obj.welcomePage();
        System.out.println("Already a member press 1 else 2");
        press = sc.nextInt();
        
        if(press == 2)
       {
        
        ob.userDetails();
        
        
        obj.eligibility(obj2.getName(), obj2.getCity(), obj2.getPhonenumber(), obj2.getPan(), obj2.getAge(),obj2.getSal(), obj2.getExpense());
        if(OTP == 1)
        {
             obj.endMessage();
             
             obj6.display();
        }
        }
        else if(press == 1)
        {
        	ob.userDetails1();
        	
      
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
                
                obj.endMessage();
                
                obj6.display();
        		}
        		else if(num==4)
        		{
        			obj6.display();
        		}
        		else if(num ==2)
        		{
        			obj6.deleteInfo();
        		}
        		else
        		{
        			obj6.updateInfo();
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
