import model.HcUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReturnToMenu
 */
@WebServlet("/ReturnToMenu")
public class ReturnToMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnToMenu() {
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
		HttpSession session = request.getSession();
		String sendTo = "StudentMenu.jsp";
		if(((HcUser)session.getAttribute("usersession")).getHcType().equalsIgnoreCase("Instructor") ){
			sendTo = "InstructorMenu.jsp";
		}
		request.getRequestDispatcher(sendTo).forward(request, response);
	}
	
	/*
	Add this button to each page later
	
<form action="ReturnToMenu" method="post">
	<input type="submit" value="Return to menu">
</form>
	 */
}
