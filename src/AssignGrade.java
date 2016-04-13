import model.HcStudentreg;
import model.HcCours;
import model.HcStudent;
import customTools.DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AssignGrade
 */
@WebServlet("/AssignGrade")
public class AssignGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignGrade() {
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
		long regid = Long.parseLong(request.getParameter("reg"));
		String newGrade = request.getParameter("grade");
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		String qString = "SELECT h FROM HcStudentreg h WHERE h.regid = " + regid;
		TypedQuery<HcStudentreg> q = em.createQuery(qString, HcStudentreg.class);
		
		try {
			HcStudentreg reg = q.getSingleResult();
			reg.setGrade(newGrade);
			String classid = String.valueOf(reg.getHcClass().getClassid());
			request.setAttribute("classid", classid);
			
			em.merge(reg);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		
		
		request.getRequestDispatcher("InstructorMenu.jsp");
	}

}
