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
 * Servlet implementation class resetPassword
 */
@WebServlet("/resetPassword")
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPassword() {
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
		System.out.println("update password...");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("newPass");
		
		System.out.println("Information: " + uname + pass);
		
		AuthDAO auth = new AuthDAO();
		
		//boolean usersignup = signup.checkUserNameAvailable(uname);
		
		String update = auth.resetPass(uname, pass);
		if(update.equals("SUCCESS"))   
		{
			// update User bean in session
			//request.getSession().setAttribute("user", signupUser);
			request.getRequestDispatcher("/homeLogin.jsp").forward(request, response);
		}
		else  
		{
		request.setAttribute("errMessage", update);
		request.getRequestDispatcher("/resetPassword.jsp").forward(request, response);
		}
	}

}
