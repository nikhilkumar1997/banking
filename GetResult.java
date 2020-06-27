package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;


public class GetResult extends HttpServlet 
{	
	 boolean value;
	private String name;
	private Object usn1;
	private int marks1;
	private int marks2;
	private int marks3;
	private int avg;
	private HttpSession session;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String usn=request.getParameter("usn");
		System.out.println(usn);
		Model m=new Model();
		m.setUsn(usn);
		try {
			value=m.getResult();
			if(value==true)
			{
				m.getResult2();
				name=m.getName();
				usn1=m.getUsn1();
				marks1=m.getMarks1();
				marks2=m.getMarks2();
				marks3=m.getMarks3();
				avg=m.getAvg();
				session=request.getSession(true);
				session.setAttribute("name", name);
				session.setAttribute("usn1", usn1);
				session.setAttribute("m1", marks1);
				session.setAttribute("m2", marks2);
				session.setAttribute("m3", marks3);
				session.setAttribute("avg", avg);

				response.sendRedirect("/MVC1/Viewresult.jsp");
			}
			else
			{
				response.sendRedirect("/MVC1/Error.html");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
