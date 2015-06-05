package myhome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSItemServlet
 */
public class BBSItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("NUM");
		BBSItem item = new BBSItem();
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "hr");
			
			if(conn == null) throw new Exception("DB연결 실패!");
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bbs where seqno="+num);
			
			if(rs.next()) {
				item.setSeqNo(rs.getInt("seqno"));
				item.setTitle(rs.getString("title"));
				item.setWriter(rs.getString("id"));
				item.setContent(rs.getString("content"));
			}
			
		}catch(Exception e) {
			
			throw new ServletException("글 검색하는 동안 예외!");
			
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		request.setAttribute("ITEM", item);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=bbsContentView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	
}
