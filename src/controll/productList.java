package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.Product;

@WebServlet("/productList")
public class productList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**     * @see HttpServlet#HttpServlet()
     */
    public productList() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Product> list = null;
		 AuthDAO dao = new AuthDAO();
		 list = dao.queryProduct();
		   
	     request.setAttribute("productList", list);
	         
	     request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

}
