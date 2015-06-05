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
 * Servlet implementation class BBSReadServlet
 */
public class BBSReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*bbs 테이블에서 글을 select
		페이지 변환*/
		
		BBSList list = readDB();
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=bbsListView.jsp");
		rd.forward(request, response);
		
	}

	private BBSList readDB() throws ServletException {
		
		BBSList list = new BBSList();
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "hr");
			
			if(conn == null) throw new Exception("DB연결 실패!");
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from bbs order by seqno desc"); //역순 정렬
			
			for(int i = 0; i < 5; i++) {
				if(!rs.next()) break;
				list.setSeqNo(i, rs.getInt("seqno"));
				list.setTitle(i, rs.getString("title"));
				list.setWriter(i, rs.getString("id"));
			}
	
		}catch(Exception e) {
			
			throw new ServletException("게시글 검색 중 예외!");
			
		}finally {
			
			try{
				
				stmt.close();
				conn.close();
				
			}catch(Exception e) {}
			
		}
		
		return list;
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
