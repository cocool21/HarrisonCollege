

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import model.HcUser;

@SuppressWarnings("unused")
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here 1");
		String user_name =request.getParameter("username");
		String password =request.getParameter("password");
		
		dblogin db= new dblogin();
		List<HcUser> user=db.searchUser(user_name, password).getResultList();
		if(user.isEmpty())
		{
			request.setAttribute("message","Invalid User or Password!!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else
		{
			HttpSession session= request.getSession() ;
			HcUser u =user.get(0);//gets 1st user out of list as resultlist contains one user
			session.setAttribute("usersession", u);
			System.out.println(u.getUserid() + u.getPassword() +u.getUsername());
		}
		
	}

}
