package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SendEmailUsingGMailSMTP;
import model.AuthDAO;
import model.Product;
import model.User;
/**
 * Servlet implementation class deleteProduct
 */
@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String id = request.getParameter("productID");
		 int productID = Integer.parseInt(id);
		 AuthDAO dao = new AuthDAO();
		 Product product = dao.searchProductByID(productID);
		 User user = dao.getUserById(product.getSellerID());
		 dao.deleteProduct(productID);
		 
		 String msg = "Hi user,\nYour product - " + product.getName() + " has been deleted. Please contact administrator if you have any questions.\n\nThe E-commerce team.";
		 System.out.println(user.getEmail());
		 SendEmailUsingGMailSMTP smtp = new SendEmailUsingGMailSMTP();
		 smtp.sendEmail(user.getEmail(), "Your post has been deleted", msg);
		 request.getRequestDispatcher("homeLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
