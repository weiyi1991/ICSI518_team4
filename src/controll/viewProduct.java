package controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.Product;
import model.User;

/**
 * Servlet implementation class viewProduct
 */
@WebServlet("/viewProduct")
public class viewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int PID = Integer.parseInt(request.getParameter("pid"));
		System.out.print(PID);
		AuthDAO dao = new AuthDAO();
		Product product = null;
		product = dao.searchProductByID(PID);	// get product by product ID
		User seller = null;
		seller = dao.getUserById(product.getSellerID());	// get user by product's seller ID
		request.setAttribute("product", product);
		request.setAttribute("seller", seller);
		request.getRequestDispatcher("viewProduct.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
