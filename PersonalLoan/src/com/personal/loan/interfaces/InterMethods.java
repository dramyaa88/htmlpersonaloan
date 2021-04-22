package com.personal.loan.interfaces;

public interface InterMethods {
    
	public abstract void welcomePage();
	public abstract void eligibility(String name, String city, String phNumber, String pan,int sal, int expense);
	public abstract void loanDetails(int loanAmount,int tenure);
	public abstract void endMessage();
	public abstract void newUserDetails();
	public abstract void existingUserDetails();
	public abstract void loanChange();
	public abstract void insertDisplay();
	public abstract void display();
	public abstract void deleteInfo();
	public abstract void validate();
	public abstract void updateInfo();

}
