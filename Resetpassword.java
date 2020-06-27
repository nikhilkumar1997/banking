package bankapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Resetpassword extends HttpServlet
{
	private HttpSession session;
	private int acc_no;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
                String password=request.getParameter("npwd");
                acc_no=(int)session.getAttribute("acc_no");
                
                model m= new model();
                m.setPassword(password);
                m.setAcc_no(acc_no);
                try
                {
                	if(m.reset()==true)
                	{
                		response.sendRedirect("/bankapp/resetsuccess.html");
                	}
                	else
                	{
                		response.sendRedirect("/bankapp/resetfail.html");

                	}
                }
                catch (Exception e) 
                {
        			
        			e.printStackTrace();
        		}
	}
}	
	



