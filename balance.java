package bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class balance extends HttpServlet {
	private HttpSession session;
	
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session=request.getSession();
		model m=new model();
		m.setAcc_no((int)session.getAttribute("acc_no"));
		try 
		{
			if(m.checkbalance())
			{
				session.setAttribute("balance",m.getBalance() );
				response.sendRedirect("/bankapp/balance.jsp");
				
			}
			else
			{
				response.sendRedirect("/bankapp/balancefail.html");
				
			}
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
