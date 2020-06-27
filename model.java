package bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class model
{
	private String url="jdbc:oracle:thin:@//localhost:1521/xe";
	private String id="system";
	private String pass="system";
	private Connection con;
	private String name,password,email,userid;
	private int acc_no,balance;
	private PreparedStatement pstmt;
	private ResultSet res;
	private boolean value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url,id,pass);
			System.out.println("Connected");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	   public boolean login()throws Exception
		{
				pstmt=con.prepareStatement("Select * from bank where user_id=? and password=?");
				
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				res=pstmt.executeQuery();
				value=res.next();
			if(value==true)	
			{
				acc_no=res.getInt(2);
				return true;
			}
			else
			{
				return false;
			}
		}
	   public boolean checkbalance() throws Exception
	   {
	   pstmt=con.prepareStatement("select balance from bank where acc_no=?");
       pstmt.setInt(1, acc_no);  
       res=pstmt.executeQuery();
       value=res.next();
       
       if(value==true)
       {
    	   balance=res.getInt(1);
    	   return true;
    	   }
       else
       {
    	   return false;
       }
	 
	   } 
	   public boolean reset() throws Exception
	   {
		   pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE ACCNO=?");
		   pstmt.setString(1, password);
		   pstmt.setInt(2,acc_no);
		   int row=pstmt.executeUpdate();
		   if(row==0)
		   {
			   return false;
		   }
		   else
		   {
			   return true;
			
		   }
		   }
	   }

	
