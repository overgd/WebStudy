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
 * Servlet implementation class BBSPostServlet
 */
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSPostServlet() {
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
		
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("ID");
		if(id == null) {
			throw new ServletException("�ȵƴ� �α���!");
		}
		
		String title = request.getParameter("TITLE");
		if(title == null) {
			throw new ServletException("���� ����!");
		}
		
		String content = request.getParameter("CONTENT");
		int seqNo = 1;//���� �۸�
	
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "hr");
			
			if(conn == null) throw new Exception("DB���� ����!");
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(seqno) max_seqno from bbs");
			
			if(rs.next()) {
				seqNo = rs.getInt("max_seqno") + 1;
			}
			
			String insert="insert into bbs values("+seqNo+",'"+title+"', '"+content+"', '"+id+"')";
			
			stmt.executeUpdate(insert);
		
		}catch(Exception e) {
			throw new ServletException("�� ��� �� ����!");
		}finally {
			try{
				stmt.cancel();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		
		response.sendRedirect("bbs_list");
	}

}
