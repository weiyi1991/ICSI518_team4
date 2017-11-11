package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.Feedback;
import model.User;

/**
 * Servlet implementation class feedbackList
 */
@WebServlet("/feedbackList")
public class feedbackList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedbackList() {
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
		 List<Feedback> list = null;
		 AuthDAO dao = new AuthDAO();
		 list = dao.queryFeedback();
		   
	     request.setAttribute("feedbackList", list);
	         
	     request.getRequestDispatcher("feedbackList.jsp").forward(request, response);
	}

}
