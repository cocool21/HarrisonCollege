

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
		
		ViewGradeSheetDb vgs = new ViewGradeSheetDb();
		List<HcClass> classList=null;
		List<HcStudentreg> studentClassList=null;
		long count=0; 
		long instructor_id=0, class_id=0;
		String semester=null;
		String message=null;


		//assume instructorid, userid and semester are in session and available to me
		//		session.setAttribute("instructorid", 1);
		//		
//				instructor_id = (long)session.getAttribute("instructorid");
//				semester = (String)session.getAttribute("semester");
//				class_id = (long)session.getAttribute("classid");


		//count = vgs.findAnyClasses((int)session.getAttribute("instructorid"));
//		count = vgs.findAnyClasses(1);
//
//		System.out.println("==>count<==========" + count);
//		message="count is " + count;

//		request.setAttribute("message", message);
//		request.getRequestDispatcher("/gradeSheetOutput.jsp").forward(request, response);
//Can't do at both places


//		if(count > 0)
//		{
//			System.out.println("im here");
			
			studentClassList = ViewGradeSheetDb.findAllClassStudentReg(1, 1, "Fall 2015");
//if(studentClassList == null)
//	message = "no studentClassList";
//else
//	message = "found studentClassList";
//System.out.println("We have something in the assignmentList:" + studentClassList);
			request.setAttribute("studentlist",studentClassList);

//request.setAttribute("message",message);
			request.getRequestDispatcher("/gradeSheetOutput.jsp").forward(request, response);
		//}
	}

}
