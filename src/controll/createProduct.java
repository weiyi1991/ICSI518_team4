package controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthDAO;
import model.Product;
import model.User;

/**
 * Servlet implementation class createProduct
 */
@WebServlet("/createProduct")
public class createProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public createProduct() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("createProduct.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String productprice = request.getParameter("price");
		int price = 0;
		
		String sellername = (String) session.getAttribute("username");
		String address = (String) session.getAttribute("address");
		
		price = Integer.parseInt(productprice);
		
		Product product = new Product();
		
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		
		
		AuthDAO create = new AuthDAO();
		
		User user = new User();
		user = create.getUserByUserName(sellername);
		product.setSellerID(user.getUserId());
		
		String newproduct = create.createProduct(product);
		String mess = "You have successfully created a product.";
		
		if(newproduct.equals("SUCCESS")) {
			request.setAttribute("Message", mess);
			request.getRequestDispatcher("homeLogin.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errMessage", newproduct);
			request.getRequestDispatcher("createProduct.jsp").forward(request, response);
		}

	}

}
