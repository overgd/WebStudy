package june10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;
import crud.CrudProcess;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		String result = null;
		
		if(checkLogin(id, pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("ID", id);
			result = "OK";
		}else {
			result = "NOK";
		}
		
		response.sendRedirect("template.jsp?BODY=loginResult.jsp?RESULT="+result);
		
	}
	
	private boolean checkLogin(String id, String passwd) throws ServletException {
		
		CrudProcess crud = new CrudProcess();
		UserInfo userInfo = crud.selectMemberById(id);
		
		if(userInfo != null) {
			
			if(userInfo.getPassword().equals(passwd)) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
		
	}

}
