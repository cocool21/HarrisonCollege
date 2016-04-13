

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HcUser;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SignUpServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String user_name =request.getParameter("newusername");
		String password = request.getParameter("newpassword");
		String year=request.getParameter("year");
		long major =Long.parseLong(request.getParameter("major"));
		System.out.println("hello"+year + major);
		dblogin db =new dblogin();
		List <HcUser> hcu=db.searchUserName(user_name).getResultList();
		if(hcu.isEmpty())
		{

			db.insertNewUser(name,user_name,password);
			db.insertNewStudent(name,user_name,year ,major);
			List<HcUser> user=db.searchUser(user_name, password).getResultList();
			HcUser u =user.get(0);//gets 1st user out of list as resultlist contains one user
			HttpSession session= request.getSession() ;
			session.setAttribute("usersession", u);
			long sid= db.getStudentID(u.getUserid());
			session.setAttribute("studentid", sid);
			request.getRequestDispatcher("/StudentMenu.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message", "User name exists please select another user name!!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}


	}

}
