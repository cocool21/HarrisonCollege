import customTools.DBUtil;
import model.HcClass;

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
 * Servlet implementation class ViewAllClasses
 */
@WebServlet("/ViewAllClasses")
public class ViewAllClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllClasses() {
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
		List<HcClass> classList = null;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h  inner join hc_cur_semester hcs "
				+ "on h.semester = hcs.currentsem ORDER BY h.classid";
			
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		try {
			classList = q.getResultList();
			request.setAttribute("classlist", classList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		request.getRequestDispatcher("AllClassList.jsp").forward(request, response);
	}

}
