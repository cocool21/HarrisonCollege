

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.HcClass;
import model.HcInstructor;
import model.HcUser;



/**
 * Servlet implementation class ViewClasses
 */
@WebServlet("/ViewClasses")
public class ViewClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClasses() {
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
	
	HttpSession session= request.getSession();
	
	long instructorid= (long) session.getAttribute("teacherid");
	
	String semester=request.getParameter("semester");
	//	String fall2015="Fall 2015";
	
	// Still need to get semester from user- query prepared for that
		
		List<HcClass> classList = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h "
				+ "where h.hcInstructor.instructorid="+ instructorid ;
			//	+" and h.semester="+semester;
			
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		
		try {
			
		
			                   
		  classList = q.getResultList();
			
			session.setAttribute("classList", classList);
	//		String name=found.getInstructorname();
	//		session.setAttribute("Name", name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		request.getRequestDispatcher("ClassList.jsp").forward(request, response);
	}

		
	}


