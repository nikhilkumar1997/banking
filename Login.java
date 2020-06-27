package bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet 
{
	private String userid;
	private String pass;
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		userid=request.getParameter("userid");
		pass=request.getParameter("pwd");
		
		model m=new model();
		
		m.setUserid(userid);
		m.setPassword(pass);
		
		try
		{
			if(m.login()==true)
			{
				session=request.getSession(true);
				session.setAttribute("acc_no", m.getAcc_no());
				response.sendRedirect("/bankapp/home.html");
			}
			else
			{
				response.sendRedirect("/bankapp/loginfail.html");
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
