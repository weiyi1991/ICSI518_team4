package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.User;

/**
 * Servlet implementation class profile_update
 */
@WebServlet("/profile_update")
public class profile_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("update profile...");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		System.out.println("Information: " + fname + lname + uname + email + address);
		
		User signupUser = new User();
		
		signupUser.setFirstName(fname);	
		signupUser.setLastName(lname);
		signupUser.setUserName(uname);
		signupUser.setPassword(pass);
		signupUser.setRole("Customer");
		signupUser.setEmail(email);
		signupUser.setAddress(address);
		signupUser.setPhoneNumber(phone);
		
		AuthDAO signup = new AuthDAO();
		
		//boolean usersignup = signup.checkUserNameAvailable(uname);
		
		String update_profile = signup.updateProfile(signupUser);
		if(update_profile.equals("SUCCESS"))   
		{
			// update User bean in session
			request.getSession().setAttribute("user", signupUser);
			request.getRequestDispatcher("/homeLogin.jsp").forward(request, response);
		}
		else  
		{
		request.setAttribute("errMessage", update_profile);
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		
	}

}
