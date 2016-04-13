package servlets;


import java.io.IOException;
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
import customTools.ProcessStudentReg;
import model.HcClass;
/**
 * Servlet implementation class AddDropServlet
 */
@WebServlet("/ClassAddListServlet")
public class ClassAddListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassAddListServlet() {
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
		List<HcClass> classList = null;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HcClass h  inner join hc_cur_semester hcs "
				+ "on h.semester = hcs.currentsem ORDER BY h.classid";
			
		TypedQuery<HcClass> q = em.createQuery(qString, HcClass.class);
		try {
			classList = q.getResultList();
			request.setAttribute("addlist", classList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("AddList.jsp").forward(request, response);
	}

	}


