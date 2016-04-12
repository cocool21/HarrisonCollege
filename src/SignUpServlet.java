

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		db.insertNewUser(name,user_name,password);
		db.insertNewStudent(name,user_name,year ,major);
		//request.getRequestDispatcher("").forward(request, response);
		
		
	}

}
