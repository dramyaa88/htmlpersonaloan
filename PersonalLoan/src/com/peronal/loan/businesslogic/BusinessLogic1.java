package com.peronal.loan.businesslogic;

import java.util.Scanner;

import com.peronal.loan.javabean.JavaBean;
import com.peronal.loan.model.First;
import com.personal.loan.interfaces.InterMethods;
import com.personal.loan.userdetails.User_Validation;



public class BusinessLogic1 implements InterMethods{
	
static int inHandSalary,check;

static int OTP;

static int interest;


static int EMI;


static int eligibility;


static int doc;


static int principal;


static int rateInPercent = 10;


static int totalInterestPayable;


JavaBean obj2 = new JavaBean();
Scanner sc = new Scanner(System.in);
User_Validation uv = new User_Validation();

    public void welcomePage() {
        System.out.println("Welcome to avail Personal Loan");
        System.out.println("-------------------------------");
        System.out.println("You can avail personal loan for ");
        System.out.println("1. Medical Emergency ");
        System.out.println("2. Debt Consolidation ");
        System.out.println("3. Higher Education");
        System.out.println("4. Home Renovation ");
        System.out.println("5. Used Cars ");
        System.out.println("6. Wedding ");
        System.out.println("7. Travel");
        System.out.println();
        System.out.println("The maximum loan amount is 200000 and the minimum loan amount is 100000");
    }
    
    

    @Override
    public void eligibility(String name, String city, String phNumber, String pan,int sal, int expense) {
    	
    		double rand = (int)Math.floor(Math.random()*(9999-1111+1)+1111);
            uv.setOtp(rand);
            System.out.println(uv.getOtp());
            System.out.println("Enter the Otp: ");
            check = sc.nextInt();
            if (check==rand) {
        if (city.equalsIgnoreCase("india")) {
            int inHandSalary;
            System.out.println();

          //  if (age >= 23 && age <= 55) {
                inHandSalary = sal - expense;
                if (inHandSalary > 15000) {
                    if (inHandSalary >= 15000 && inHandSalary <= 30000) {
                        System.out.println("You are eligible to take loan upto 500000");
                    } else if (inHandSalary > 30000 && inHandSalary <= 60000) {
                        System.out.println("you are eligible to take loan upto 100000");
                    } else {
                        System.out.println("you are eligible to take loan upto 200000");
                    }
                    eligibility = 1;
                    System.out.println("Documents Required");
                    System.out.println("1. Salary Pay \n 2. Aadhaar card \n 3. Pan card \n 4. Photographs ");
                    System.out.println("Please press 1 if you have above documents else 2");
                 //   Scanner sc = new Scanner(System.in);
                    int doc = sc.nextInt();
                    if (doc == 1) {
                        System.out.println("Proceed Further");
                        
                        System.out.println("Enter your loan Amount");
                        int loanAmount = sc.nextInt();
                        sc.nextLine();
                        obj2.setLoanAmount(loanAmount);
                        
                        System.out.println("Enter your tenure in months");
                        int tenure = sc.nextInt();
                        sc.nextLine();
                        obj2.setTenure(tenure);
                        
                        BusinessLogic2 obj = new BusinessLogic2();
                        obj.loanDetails(obj2.getLoanAmount(), obj2.getTenure());
                        
                    } else {
                        System.out.println("document  needed");
                    }
                } else {
                    System.out.println("Your In Hand Salary should be greater that 15000 for applying personal loan");
                }
//            } else {
//                System.out.println("Your age should lie between 23 and 55");
//            }
        } else {
            System.out.println("you should reside in INDIA for applying personal loan");
        }
    }
            else
            {
            	System.out.println("Wrong OTP plz try again");
            }
    }
    	
    	
    	




	@Override
	public void loanDetails(int loanAmount, int tenure) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void endMessage() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void newUserDetails() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void existingUserDetails() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void loanChange() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteInfo() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateInfo() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void insertDisplay() {
		// TODO Auto-generated method stub
		
	}
    

	
}