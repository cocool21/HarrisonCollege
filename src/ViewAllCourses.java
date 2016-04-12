import customTools.DBUtil;
import model.HcCours;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllCourses
 */
@WebServlet("/ViewAllCourses")
public class ViewAllCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<HcCours> courseList = null;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcCours h ORDER BY h.courseid";
		TypedQuery<HcCours> q = em.createQuery(qString, HcCours.class);
		try {
			courseList = q.getResultList();
			request.setAttribute("courselist", courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("AllCourseList.jsp").forward(request, response);
	}

}
