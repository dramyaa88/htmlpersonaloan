package com.peronal.loan.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.peronal.loan.javabean.JavaBean;
import com.personal.loan.interfaces.InterMethods;

public class MySQLclass extends JavaBean implements InterMethods{
	
	Scanner sc = new Scanner(System.in);
	MySQLConnection myconn=new MySQLConnection();
	Connection conn;
	JavaBean obj2 = new JavaBean();
	
	 public int validate(String uid1,String pwd1)
	  {
		 int t=0;
		conn=myconn.mySqlDBConnection();
		ResultSet rsp;
		
		
		try {
			
            String sql = "select count(uid) from login where uid=? and pwd like ?";
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1,uid1);
		
			p.setString(2, pwd1);
			
			rsp=p.executeQuery();
			
			while(rsp.next()) {
				
				 t = rsp.getInt(1);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public void updateInfo()
	{
		System.out.println("Updating phone number");
		conn=myconn.mySqlDBConnection();
		System.out.println("Enter your Mobile number");
        String phNumber = sc.nextLine();
        obj2.setPhonenumber(phNumber);
        
		String updateQuery = "update personalDetails set phoneNo = ? where uid = ?";
		
		try {
			PreparedStatement pp = conn.prepareStatement(updateQuery);
			pp.setString(1, phNumber);
			pp.setString(2, getUid());
			pp.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteInfo()
	{
		System.out.println("Deleting your information");
		conn=myconn.mySqlDBConnection();
		String deleteQuery = "delete from login where uid=?";
		String deleteQuery1 = "delete from personalDetails where uid=?";
		String deleteQuery2 = "delete from loanDetails where uid=?";
		try {
			PreparedStatement psm = conn.prepareStatement(deleteQuery);
			psm.setString(1, getUid());
			
			PreparedStatement ps = conn.prepareStatement(deleteQuery1);
			ps.setString(1, getUid());
			
			PreparedStatement pst = conn.prepareStatement(deleteQuery2);
			pst.setString(1, getUid());
			
			psm.execute();
			ps.execute();
			pst.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertDisplay()
	{
		conn=myconn.mySqlDBConnection();
		//String sqlQuery = "select deptId,deptName from department where deptId > ?";
		String addQuery = "insert into login values(?,?)";
		String addQuery1 = "insert into personalDetails values(?,?,?,?,?)";
		String addQuery2 = "insert into loanDetails values(?,?,?,?,?)";
		
		try
		{	
		PreparedStatement psmt1 = conn.prepareStatement(addQuery);
		psmt1.setString(1,getUid());
		psmt1.setString(2, getPwd());
		psmt1.executeUpdate();
		

		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}

		try
		{
			PreparedStatement psmt2 = conn.prepareStatement(addQuery1);
			psmt2.setString(1,getUid());
			psmt2.setString(2, getPhonenumber());
			psmt2.setString(3,getName());
			//psmt2.setInt(4, getAge());
			psmt2.setString(4, getCity());	
			psmt2.setString(5,getPan());
			psmt2.executeUpdate();
			
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		try
		{
			PreparedStatement psmt4 = conn.prepareStatement(addQuery2);
			psmt4.setString(1,getUid());
			psmt4.setInt(2,getSal());
			psmt4.setInt(3,getExpense());
			psmt4.setInt(4,getLoanAmount());
			psmt4.setInt(5,getTenure());
			psmt4.executeUpdate();
			

			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}
	
	public void insertUpdate()
	{
		String update = "update loanDetails set loanAmount = ? and tenure = ? where uid = ?";
		try {
			PreparedStatement ppt = conn.prepareStatement(update);
			ppt.setInt(1, getLoanAmount());
			ppt.setInt(2, getTenure());
			ppt.setString(3, getUid());
			ppt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void display()
	{
		System.out.println("Displaying your information");
		String displayQuery = "select * from login where uid=?";
		String displayQuery1 = "select * from personalDetails where uid=?";
		String displayQuery2 = "select * from loanDetails where uid=?";
		try
		{
		PreparedStatement psmt3 = conn.prepareStatement(displayQuery);
		psmt3.setString(1, getUid());
		psmt3.execute();

		ResultSet rs = psmt3.executeQuery();

		while(rs.next())
		{
			System.out.print("UID :"+rs.getString(1)+" , ");
			System.out.print("Password :"+rs.getString(2));
			System.out.println();
		
		}
		
		while(rs.next())
		{
			System.out.println();
		}
		

		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		
		try
		{
		PreparedStatement psmt5 = conn.prepareStatement(displayQuery1);
		psmt5.setString(1, getUid());
		psmt5.execute();
		
		ResultSet rs1 = psmt5.executeQuery();
		
		while(rs1.next())
		{
			System.out.print("UId :"+rs1.getString(1)+" , ");
			System.out.print("PhoneNumber :"+rs1.getString(2)+" , ");
			System.out.print("Name :"+rs1.getString(3)+" , ");
		//	System.out.print("Age :"+rs1.getInt(4)+" , ");
			System.out.print("City :"+rs1.getString(4)+" , ");
			System.out.print("Pan :"+rs1.getString(5));
			System.out.println();
		}
		
		while(rs1.next())
		{
			System.out.println();
		}
		
	}catch(SQLException e)
	{
		e.printStackTrace();
	}catch(Exception ee)
	{
		ee.printStackTrace();
	}
		
		try
		{
		
		PreparedStatement psmt6 = conn.prepareStatement(displayQuery2);
		psmt6.setString(1, getUid());
		psmt6.execute();
		
		ResultSet rs2 = psmt6.executeQuery();
		
		while(rs2.next())
		{
			System.out.print("UID :"+rs2.getString(1)+" , ");
			System.out.print("Income :"+rs2.getInt(2)+" , ");
			System.out.print("Expense :"+rs2.getInt(3)+" , ");
			System.out.print("LoanAmount :"+rs2.getInt(4)+" , ");
			System.out.print("Tenure in  months :"+rs2.getInt(5));
			System.out.println();
		}
		
		while(rs2.next())
		{
			System.out.println();
		}
		
	}catch(SQLException e)
	{
		e.printStackTrace();
	}catch(Exception ee)
	{
		ee.printStackTrace();
	}finally
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	}

	@Override
	public void welcomePage() {
		// TODO Auto-generated method stub
		
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
	public void validate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eligibility(String name, String city, String phNumber, String pan, int sal, int expense) {
		// TODO Auto-generated method stub
		
	}

}