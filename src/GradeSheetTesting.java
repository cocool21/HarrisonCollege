

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcClass;
import model.HcInstructor;
import model.HcStudentreg;

@WebServlet("/GradeSheetTesting")
public class GradeSheetTesting extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public GradeSheetTesting() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		List<HcClass> classList=null;
		long count=0; 
		int user_id=0;
		ViewGradeSheetDb vgs = new ViewGradeSheetDb();
		List<HcStudentreg> studentClassList=null;


		//assume instructorid in session is available to me
		//		session.setAttribute("instructorid", 1);
		//		
		//		user_id = (int)session.getAttribute("instructorid");


		//count = vgs.findAnyClasses((int)session.getAttribute("instructorid"));
		count = vgs.findAnyClasses(1);

		System.out.println("==>count<==========" + count);
		String message="count is " + count;

//		request.setAttribute("message", message);
//		request.getRequestDispatcher("/gradeSheetOutput.jsp").forward(request, response);
//Can't do at both places


		if(count > 0)
		{
			System.out.println("im here");
			classList = vgs.findAllClassesList(1).getResultList();
			
			
			studentClassList = vgs.findAllClassStudentList(1).getResultList();
			
			

			System.out.println("We have something in the assignmentList:" + classList);
			request.setAttribute("message",classList);
			request.getRequestDispatcher("/gradeSheetOutput.jsp").forward(request, response);
		}
	}

}
