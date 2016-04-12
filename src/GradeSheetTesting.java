

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GradeSheetTesting
 */
@WebServlet("/GradeSheetTesting")
public class GradeSheetTesting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeSheetTesting() {
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
		//doGet(request, response);
		
		
		HttpSession session = request.getSession();
//		List<DcuAccount> accountList=null;
//		AccountDetailDb accDb = new AccountDetailDb();
		long count=0; 
		int user_id=0;
		ViewGradeSheetDb vgs = new ViewGradeSheetDb();

		
		//assume instructorid in session is available to me
//		session.setAttribute("instructorid", 1);
//		
//		user_id = (int)session.getAttribute("instructorid");
		

		//count = vgs.findAnyClasses((int)session.getAttribute("instructorid"));
		count = vgs.findAnyClasses(1);

System.out.println("==>count<==========" + count);
//		if(count > 0)
//		{
//		
//			accountList = accDb.findAllAccountList((int)session.getAttribute("userid")).getResultList();
//			//accountList = accDb.findAllAccountList((long)1).getResultList();
//
//			//System.out.println("We have something in the assignmentList");
//			request.setAttribute("accountList", accountList);
//			request.getRequestDispatcher("/AccountDetail.jsp").forward(request, response);
//		}
	}

}
