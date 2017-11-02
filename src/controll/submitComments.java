package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.Comments;

/**
 * Servlet implementation class submitComments
 */
@WebServlet("/submitComments")
public class submitComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitComments() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		float rates = Float.parseFloat(request.getParameter("rates"));

		System.out.println("uid, pid, sid" + uid + " " +  pid + " " +  sid);
		String comm = request.getParameter("comments");
		
		Comments comments = new Comments();
		AuthDAO dao = new AuthDAO();
		comments.setUserID(uid);
		comments.setProductID(pid);
		comments.setSellerID(sid);
		comments.setRates(rates);
		comments.setComments(comm);
		
		String message = dao.creatComments(comments);
		String mess = "You have successfully created a comment.";
		
		if(message.equals("SUCCESS")) {
			request.setAttribute("Message", mess);
			request.getRequestDispatcher("homeLogin.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errMessage", message);
			request.getRequestDispatcher("homeLogin.jsp").forward(request, response);
		}
		
	}

}
