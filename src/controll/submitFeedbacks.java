package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.Comments;
import model.Feedback;

/**
 * Servlet implementation class submitFeedbacks
 */
@WebServlet("/submitFeedbacks")
public class submitFeedbacks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitFeedbacks() {
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

		System.out.println("uid, pid, sid" + uid + " " +  pid + " " +  sid);
		String feedback = request.getParameter("feedback");
		
		Feedback fb = new Feedback();
		AuthDAO dao = new AuthDAO();
		fb.setUserID(uid);
		fb.setProductID(pid);
		fb.setSellerID(sid);
		fb.setFeedback(feedback);
		
		String message = dao.creatFeedbacks(fb);
		String mess = "You have successfully created a feedback.";
		
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
