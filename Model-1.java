package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private String userid="system";
	private String password="SYSTEM";
    private Connection con;
    private String usn=null;
    private String name=null;
    private int marks1;
    private int marks2;
    private int marks3;
	private int avg;
	private PreparedStatement pstmt;
	private ResultSet res;
	private boolean value;
	private String usn1;
    public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getUsn1() {
		return usn1;
	}
	public void setUsn1(String usn1) {
		this.usn1 = usn1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public Model()
	{
		try 
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url, userid, password);
			System.out.println("connection is established");
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public boolean getResult()throws Exception
	{
		pstmt=con.prepareStatement("select * from student where usn=?");
			pstmt.setString(1,usn);
			res=pstmt.executeQuery();
			value=res.next();
		return value;

	}
	public void getResult2()
	{
	try {	
		usn1=res.getString(2);
		name=res.getString(1);
		marks1=res.getInt(3);
		marks2=res.getInt(4);
		marks3=res.getInt(5);
		avg=res.getInt(6);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
}
