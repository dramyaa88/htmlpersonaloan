package com.peronal.loan.javabean;

public class JavaBean {
	private static String name;
    private static String city;
    private static String Phonenumber;
    private static String pan;
    private static int sal;
    private static int expense;
//    private static int age;
    private static String uid;
    private static String pwd;
    private static int loanAmount;
    private static int tenure;

    public int getLoanAmount() {
		return loanAmount;
	}



	public void setLoanAmount(int loanAmount) {
		JavaBean.loanAmount = loanAmount;
	}



	public int getTenure() {
		return tenure;
	}



	public void setTenure(int tenure) {
		JavaBean.tenure = tenure;
	}



	public String getUid() {
		return uid;
	}

	

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public JavaBean(String name, String city, String pan, int sal,int expense, int age, String uid,
			String pwd) {
		super();
		this.name = name;
		this.city = city;
		this.pan = pan;
		this.sal = sal;
		this.expense = expense;
//		this.age = age;
		this.uid = uid;
		this.pwd = pwd;
	}



	public JavaBean() {
		super();
	}



	public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }



	

}