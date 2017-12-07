package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.User;
import util.SendEmailUsingGMailSMTP;

/**
 * Servlet implementation class forgetPass
 */
@WebServlet("/forgetPass")
public class forgetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetPass() {
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
		System.out.println("forget password...");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		
		System.out.println("Information: " + uname + email);
		
		AuthDAO auth = new AuthDAO();
		
		//boolean usersignup = signup.checkUserNameAvailable(uname);
		
		User user = auth.getUserByUserName(uname);
		if(user!=null)   
		{
			// update User bean in session
			//request.getSession().setAttribute("user", signupUser);
			System.out.println("Email: " + user.getEmail());
			if(user.getEmail().equals(email)){
				String msg = "Hi user,\nThe password of account - " + user.getUserName() + " is \n" + user.getPassword() + "\nPlease reset your password for security.\n\nThe E-commerce team.";
				SendEmailUsingGMailSMTP smtp = new SendEmailUsingGMailSMTP();
				smtp.sendEmail(user.getEmail(), "Your password on E-commerce", msg);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
			else{
				request.setAttribute("errMessage", "Username and E-mail are not matching.");
				request.getRequestDispatcher("/forgetPass.jsp").forward(request, response);
			}
			
		}
		else  
		{
			request.setAttribute("errMessage", "Username not exist.");
			request.getRequestDispatcher("/forgetPass.jsp").forward(request, response);
		}
	}

}
