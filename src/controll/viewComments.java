package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.Comments;
import model.Product;

/**
 * Servlet implementation class viewComments
 */
@WebServlet("/viewComments")
public class viewComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewComments() {
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
		List<Comments> list = null;
		AuthDAO dao = new AuthDAO();
		int id = (Integer) request.getSession(false).getAttribute("userId");
		System.out.println("user id: " + id);
		list = dao.myComments(id);
		   
	    request.setAttribute("commentsList", list);
	         
	    request.getRequestDispatcher("viewComments.jsp").forward(request, response);
	}

}
