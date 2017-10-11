package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.User;
import model.AuthDAO;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String uname = request.getParameter("username");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		
	
		
		User signupUser = new User();
		
		signupUser.setFirstName(fname);	
		signupUser.setLastName(lname);
		signupUser.setUserName(uname);
		signupUser.setPassword(pass);
		signupUser.setRole("Customer");
		signupUser.setEmail(email);
		
		AuthDAO signup = new AuthDAO();
		
		//boolean usersignup = signup.checkUserNameAvailable(uname);
		
		String userRegistered = signup.registerUser(signupUser);
		if(userRegistered.equals("SUCCESS"))   
		{
		request.getRequestDispatcher("/nav.jsp").forward(request, response);
		}
		else  
		{
		request.setAttribute("errMessage", userRegistered);
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
		}
		/*
		if(usersignup) {
			signup.enterNewUser(uname, pass, role);
			request.getRequestDispatcher("/nav.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errMessage", signup);
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
		}
		}*/
	}
}
