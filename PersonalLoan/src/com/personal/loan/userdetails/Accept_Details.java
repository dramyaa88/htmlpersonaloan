package com.personal.loan.userdetails;

import java.util.Scanner;

import com.peronal.loan.businesslogic.BusinessLogic2;
import com.peronal.loan.javabean.JavaBean;
import com.personal.loan.interfaces.InterMethods;

public class Accept_Details extends BusinessLogic2 implements InterMethods{
	
	 Scanner sc = new Scanner(System.in);
	 JavaBean obj2 = new JavaBean();
	 
	 public void newUserDetails()
	{
	
	System.out.println("Enter your Name");
    String name = sc.nextLine();
    obj2.setName(name);
    
    System.out.println("Enter your UserId");
    String uid = sc.next();
    sc.nextLine();
    obj2.setUid(uid);
    
    System.out.println("Set Password");
    String pwd = sc.next();
    sc.nextLine();
    obj2.setPwd(pwd);
    
    System.out.println("Enter your country");
    String city = sc.nextLine();
    obj2.setCity(city);

    System.out.println("Enter your Mobile number");
    String phNumber = sc.next();
    sc.nextLine();


    //Regular expression to accept valid phone number
    String regex = "\\d{10}";
    
    //Matching the given phone number with regular expression
    boolean result = phNumber.matches(regex);
    
    if(result) {
        System.out.println("Given phone number is valid");
    } else {
        System.out.println("Given phone number is not valid");
        System.exit(0);
    }
    obj2.setPhonenumber(phNumber);
    
    System.out.println("Enter your PAN Number");
    String pan = sc.nextLine();
    obj2.setPan(pan);
    
//    System.out.println("Enter your Age");
//    int age = sc.nextInt();
//    sc.nextLine();
//    obj2.setAge(age);
    
    System.out.println("Enter Monthly Salary");
    int sal = sc.nextInt();
    sc.nextLine();
    obj2.setSal(sal);
    
    System.out.println("Enter your expenses");
    int expense = sc.nextInt();
    sc.nextLine();
    obj2.setExpense(expense);
	}
	
	public void existingUserDetails()
	{
		System.out.println("Enter your UserId");
    	String uid1 = sc.next();
    	sc.nextLine();
    	obj2.setUid(uid1);
    	
    	System.out.println("Enter your Password");
        String pwd1 = sc.next();
        sc.nextLine();
        obj2.setPwd(pwd1);
	}
	
	public void loanChange()
	{
		System.out.println("Enter your loan Amount");
        int loanAmount = sc.nextInt();
        sc.nextLine();
        obj2.setLoanAmount(loanAmount);
        
        System.out.println("Enter your tenure in months");
        int tenure = sc.nextInt();
        sc.nextLine();
        obj2.setTenure(tenure);
	}
	
}
