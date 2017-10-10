package controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import model.AuthDAO;
import model.User;
import model.User;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			String role = request.getParameter("role");
			//String fname = "";
			//String lname = "";
						
			User user = new User();
			User login_user = new User();
			
			user.setUserName(username);
			user.setPassword(password);
			user.setRole(role);
			
			AuthDAO login = new AuthDAO();

			String userValidate = login.authenticateUser(user);
			
			login_user = login.getUserByUserName(username);
			//System.out.println(login_user.getUserName());
			//System.out.println(login_user.getPassword());
			//System.out.println("f" + login_user.getUserFirstName());
			//System.out.println("l" + login_user.getUserLastName());
			
			if(userValidate.equals("Customer")){
									
					HttpSession session = request.getSession(); //Creating a session
					
					session.setAttribute("user", login_user);
					
					System.out.println("log in session:" + session.getAttribute("user"));
						
					session.setAttribute("username", username);
					session.setAttribute("role", role);
					session.setAttribute("firstname", login_user.getUserFirstName());
					session.setAttribute("lastname", login_user.getUserLastName());
					
					request.setAttribute("username", username);
					request.setAttribute("role", role);
					request.setAttribute("firstname", login_user.getUserFirstName());
					request.setAttribute("lastname", login_user.getUserLastName());
					
					request.getRequestDispatcher("customer.jsp").forward(request, response);
				}	
				
				else if(userValidate.equals("Admin")){
					HttpSession session = request.getSession(); //Creating a session
					session.setAttribute("role", role); 
					
					request.setAttribute("username", username);
					request.setAttribute("role", role);
					request.setAttribute("firstname", login_user.getUserFirstName());
					request.setAttribute("lastname", login_user.getUserLastName());
					
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}	
				

				else {
					//request.setAttribute("errMessage", userValidate);
					request.getRequestDispatcher("error.jsp").forward(request, response);
					
				}
				}

}


