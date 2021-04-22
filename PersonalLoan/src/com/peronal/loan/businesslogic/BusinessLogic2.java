package com.peronal.loan.businesslogic;

import com.personal.loan.interfaces.InterMethods;

public class BusinessLogic2 extends BusinessLogic1 implements InterMethods{
	
public void loanDetails(int loanAmount,int tenure) {
	
		if (eligibility == 1) {
            principal =loanAmount;
            System.out.println(principal);
            try
            {
                totalInterestPayable = (principal * tenure * rateInPercent) / 100;
                EMI = (principal + totalInterestPayable) / tenure;
                System.out.println("Interest :"+EMI);
                System.out.println("Total Amount :"+(principal+EMI));
            }catch(ArithmeticException e)
            {
            	e.printStackTrace();
            }
		}
                
		
	}


	
	public void endMessage() {
		System.out.println("You successfully applied for the loan");
        System.out.println("Have a nice day");
		
	}
}
