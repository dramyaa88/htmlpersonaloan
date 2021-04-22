
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLclass extends JavaBean{
	
	static Scanner sc = new Scanner(System.in);
	static MySQLConnection myconn=new MySQLConnection();
	static Connection conn;
	static JavaBean obj2 = new JavaBean();
	
	int validate(int i,String pwd1)
	{
		conn=myconn.mySqlDBConnection();
		ResultSet rsp;
		
		
		try {
			

			Statement p=conn.createStatement();
			//p.setString(1,uid1);
		//	PreparedStatement p2=conn.prepareStatement(sqlQuery1);
			//p.setString(2, pwd1);
			
			 rsp=p.executeQuery("select uid,pwd from login where uid="+i);
			//ResultSet rsp2=p2.executeQuery();
			//String t ,t1;
			while(rsp.next()) {
				
				 int t = rsp.getInt(1);
				
				String t1 = rsp.getString(2);
				
					
			
			if(t==i && t1==pwd1) {
				return 1;
			}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	void updateInfo()
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
			pp.setInt(2, getUid());
			pp.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void deleteInfo()
	{
		System.out.println("Deleting your information");
		conn=myconn.mySqlDBConnection();
		String deleteQuery = "delete from login where uid=?";
		String deleteQuery1 = "delete from personalDetails where uid=?";
		String deleteQuery2 = "delete from loanDetails where uid=?";
		try {
			PreparedStatement psm = conn.prepareStatement(deleteQuery);
			psm.setInt(1, getUid());
			
			PreparedStatement ps = conn.prepareStatement(deleteQuery1);
			ps.setInt(1, getUid());
			
			PreparedStatement pst = conn.prepareStatement(deleteQuery2);
			pst.setInt(1, getUid());
			
			psm.executeQuery();
			ps.executeQuery();
			pst.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void display()
	{
		System.out.println("Displaying your information");
		conn=myconn.mySqlDBConnection();
		//String sqlQuery = "select deptId,deptName from department where deptId > ?";
		String addQuery = "insert into login values(?,?)";
		String addQuery1 = "insert into personalDetails values(?,?,?,?,?,?)";
		String addQuery2 = "insert into loanDetails values(?,?,?,?,?)";
		
		String displayQuery = "select * from login where uid=?";
		String displayQuery1 = "select * from personalDetails where uid=?";
		String displayQuery2 = "select * from loanDetails where uid=?";
		try
		{

			
		PreparedStatement psmt1 = conn.prepareStatement(addQuery);
		psmt1.setInt(1,getUid());
		psmt1.setString(2, getPwd());
		psmt1.executeUpdate();
		
		PreparedStatement psmt3 = conn.prepareStatement(displayQuery);
		psmt3.setInt(1, getUid());
		psmt3.execute();

		ResultSet rs = psmt3.executeQuery();

		while(rs.next())
		{
			System.out.print("UID :"+rs.getString(1)+" , ");
			System.out.print("Password :"+rs.getString(2));
			System.out.println();
//		
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
			PreparedStatement psmt2 = conn.prepareStatement(addQuery1);
			psmt2.setInt(1,getUid());
			psmt2.setString(2, getPhonenumber());
			psmt2.setString(3,getName());
			psmt2.setInt(4, getAge());
			psmt2.setString(5, getCity());	
			psmt2.setString(6,getPan());
			psmt2.executeUpdate();
			
			PreparedStatement psmt5 = conn.prepareStatement(displayQuery1);
			psmt5.setInt(1, getUid());
			psmt5.execute();
			
			ResultSet rs1 = psmt5.executeQuery();
			
			while(rs1.next())
			{
				System.out.print("UserId :"+rs1.getString(1)+" , ");
				System.out.print("PhoneNumber :"+rs1.getString(2)+" , ");
				System.out.print("Name :"+rs1.getString(3)+" , ");
				System.out.print("Age :"+rs1.getInt(4)+" , ");
				System.out.print("City :"+rs1.getString(5)+" , ");
				System.out.print("Pan :"+rs1.getString(6));
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
			PreparedStatement psmt4 = conn.prepareStatement(addQuery2);
			psmt4.setInt(1,getUid());
			psmt4.setInt(2,getSal());
			psmt4.setInt(3,getExpense());
			psmt4.setInt(4,getLoanAmount());
			psmt4.setInt(5,getTenure());
			psmt4.executeUpdate();
			
			PreparedStatement psmt6 = conn.prepareStatement(displayQuery2);
			psmt6.setInt(1, getUid());
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
	

	

}