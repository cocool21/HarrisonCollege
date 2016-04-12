

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.ProcessStudentReg;
import model.HcStudent;
import model.HcStudentreg;

/**
 * Servlet implementation class GetRosterByClass
 */
@WebServlet("/GetRosterByClass")
public class GetRosterByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRosterByClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		

//		long classid = Long.parseLong(session.getAttribute("classid"));
		long classid = (long) session.getAttribute("classid");
		

		System.out.println("classid = " + classid);
		
	
			List<HcStudent> roster = null;

			roster = ProcessStudentReg.getStudentList(classid);

			request.setAttribute("roster", roster);
			
			
			request.getRequestDispatcher("/displayRoster.jsp").forward(request, response);

		}	
		
	}


