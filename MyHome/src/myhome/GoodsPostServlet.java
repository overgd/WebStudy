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
 * Servlet implementation class GoodsPostServlet
 */
public class GoodsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsPostServlet() {
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

		request.setCharacterEncoding("euc_kr");
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("ID");
		if(id == null) {
			throw new ServletException("로그인이 안됨");
		}
		
		String name = request.getParameter("NAME");
		if(name == null) {
			throw new ServletException("제목이 없다!");
		}
		
		String price = request.getParameter("PRICE");
		if(price == null) {
			throw new ServletException("가격이 없다!");
		}
		
		int code = 1;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "hr");
			
			if(conn == null) throw new Exception("DB연결 실패!");
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(code) max_code from goods");
			
			if(rs.next()) {
				code = rs.getInt("max_code") + 1;
			}
			
			String insert="insert into goods values("+code+",'"+name+"', "+price+", '"+id+"')";
			
			stmt.executeUpdate(insert);
		
		}catch(Exception e) {
			throw new ServletException("글 등록 중 예외!");
		}finally {
			try{
				stmt.cancel();
				conn.close();
			}catch(Exception e) {
				
			}
		}
		
		response.sendRedirect("goods_list");
	}

}
