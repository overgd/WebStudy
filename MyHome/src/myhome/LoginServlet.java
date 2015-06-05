package myhome;

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
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "hr");
			
			if(conn == null) throw new Exception("DB연결 실패!");
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select password from uinfo where id='"+id+"'");
			
			if(!rs.next()) {
				return false;
			}
			
			String password = rs.getString("password");
			
			if(passwd.equals(password)) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			
			throw new ServletException(e);
		
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		
		
	}

}
