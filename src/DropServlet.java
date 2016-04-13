

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import customTools.ProcessStudentReg;
import model.HcClass;

/**
 * Servlet implementation class DropServlet
 */
@WebServlet("/DropServlet")
public class DropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       HttpSession session = request.getSession();
		
		long studentid = (long) session.getAttribute("studentid");
		long classid = Long.parseLong(request.getParameter("drop"));
		System.out.println(classid);
		ProcessStudentReg.dropClass(studentid, classid);
		
		request.getRequestDispatcher("RegisteredClasses.jsp").forward(request, response);
	}

}
