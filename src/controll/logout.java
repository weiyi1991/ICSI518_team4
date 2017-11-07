package controll;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false); 
		session.invalidate(); 
		
		request.setAttribute("errMessage", "You have logged out successfully");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/logout.jsp");
		requestDispatcher.forward(request, response);
		//response.sendRedirect("/login.jsp");
		System.out.println("Logged out");
	
	}
}
