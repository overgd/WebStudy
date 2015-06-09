package myhome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
		String pageNo = request.getParameter("PAGE_NO");
		String lastNo = request.getParameter("LAST_NO");
		String firstNo = request.getParameter("FIRST_NO");
		
//		System.out.println("pageNo:["+pageNo+"]");
//		System.out.println("lastNo:["+lastNo+"]");
//		System.out.println("firstNo:["+firstNo+"]");
		
		BBSList list = null;
		
		if(pageNo != null) {
			list = readPage(Integer.parseInt(pageNo));
		}else if(firstNo != null) {
			list = readPrevPage(Integer.parseInt(firstNo));
		}else if(lastNo != null) {
			list = readNextPage(Integer.parseInt(lastNo));
		}else {
			list = readDB();
//			System.out.println("list.listSize():["+list.getListSize()+"]");
		}
		
//		BBSList list = readDB();
		
		list.setPageNum(readPageNum());
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=bbsListView.jsp");
		rd.forward(request, response);
		
	}
	
	private int readPageNum() throws ServletException {
		
		int pageNum = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			if(conn == null){ throw new ServletException("DB 접속실패!");}
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(*) as num from bbs");
			
			if(!rs.next()) {
				return 0;
			}
			pageNum = rs.getInt("num");
			
		}catch(Exception e) {
			throw new ServletException("글 갯수 검색시 예외발생!");
		}finally {
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
		
		return (pageNum + 4) / 5;
	}
	
	private BBSList readNextPage(int seqNo) throws ServletException {
		
		BBSList list = new BBSList();
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			if(conn == null) {
				throw new ServletException("DB 접속 실패!");
			}
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from bbs where seqno < "+seqNo+" order by seqno desc");
			
			for(int i = 0; i < 5 ;i++) {
				
				if(!rs.next()) break;
				list.setSeqNo(i, rs.getInt("seqno"));
//				System.out.println("seqno:["+rs.getInt("seqno")+"]");
				list.setTitle(i, rs.getString("title"));
				list.setWriter(i, rs.getString("id"));
			
			}
			
			if(!rs.next()) {
				list.setLastPage(true);
			}
			
		}catch(Exception e) {
			throw new ServletException("다음페이지 처리시 예외발생!");
		}finally {
			try{ stmt.close(); conn.close(); }catch(Exception e){}
		}
		return list;
	}
	
	private BBSList readPrevPage(int seqNo)	throws ServletException {
		
		BBSList list = new BBSList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			
			if(conn == null) {
				throw new ServletException("DB 접속 실패!");
			}
			
			pstmt = conn.prepareStatement("select * from bbs where seqno > "+seqNo+" order by seqno desc", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.last()) {
				throw new ServletException("마지막으로 이동불가!");
			}
			
			int rows = rs.getRow();//마지막 행의 번호 저장
			
			rs.absolute(rows - 4);//위로 4칸 이동
		
			for(int cnt = 0; cnt < 5; cnt++ ) {
				list.setSeqNo(cnt, rs.getInt("seqno"));
				list.setTitle(cnt, rs.getString("title"));
				list.setWriter(cnt, rs.getString("id"));
				if(!rs.next()) {
					break;
				}
			}
			if((rows-5) < 5) {
				list.setFirstPage(true);
			}
			
		}catch(Exception e) {
			throw new ServletException("이전 페이지 이동시 예외!");
		}finally {
			
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e){}
		}
		return list;
	}
	
	private BBSList readPage(int pageNo) throws ServletException {
		
		BBSList list = new BBSList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			
			if(conn == null) {
				throw new ServletException("DB 접속 실패!");
			}
			
			pstmt = conn.prepareStatement("select * from bbs order by seqno desc", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			if(pageNo > 1) {
				rs.absolute((pageNo-1)*5);
			}
		
			for(int cnt = 0; cnt < 5; cnt++) {
				
				if(!rs.next()) break;
				list.setSeqNo(cnt, rs.getInt("seqno"));
				list.setTitle(cnt, rs.getString("title"));
				list.setWriter(cnt, rs.getString("id"));
				
			}
			
			if(!rs.next()) {
				list.setLastPage(true);
			}
			if(pageNo == 1) {
				list.setFirstPage(true);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new ServletException("페이지 검색시 예외");
		
		}finally {
			
			try{
				
				pstmt.close();
				conn.close();
				
			}catch(Exception e) {}
			
		}
		
		return list;
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
			
			list.setFirstPage(true);
	
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
