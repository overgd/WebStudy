package june10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BBSList;
import model.BBSShowList;
import crud.CrudProcess;

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

		/*bbs ���̺��� ���� select
		������ ��ȯ*/
		
		String pageNo = request.getParameter("PAGE_NO");
		String lastNo = request.getParameter("LAST_NO");
		String firstNo = request.getParameter("FIRST_NO");
		
//		System.out.println("pageNo:["+pageNo+"]");
//		System.out.println("lastNo:["+lastNo+"]");
//		System.out.println("firstNo:["+firstNo+"]");
		
		BBSShowList list = null;
		
		if(pageNo != null) {
			list = readPage(Integer.parseInt(pageNo));
		}else if(firstNo != null) {
			
		}else if(lastNo != null) {
			
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
		
//		Connection conn = null;
//		Statement stmt = null;
//		
//		try {
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(
//				"jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
//			if(conn == null){ throw new ServletException("DB ���ӽ���!");}
//			stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery("select count(*) as num from bbs");
//			
//			if(!rs.next()) {
//				return 0;
//			}
//			pageNum = rs.getInt("num");
//			
//		}catch(Exception e) {
//			throw new ServletException("�� ���� �˻��� ���ܹ߻�!");
//		}finally {
//			try{stmt.close(); conn.close();}catch(Exception e){}
//		}
		
		CrudProcess crud = new CrudProcess();
		
		pageNum = crud.getBBSCount();
		
		return (pageNum + 4) / 5;
	}
	
	private BBSShowList readNextPage(int seqNo) throws ServletException {
		
		BBSShowList list = new BBSShowList();
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			if(conn == null) {
				throw new ServletException("DB ���� ����!");
			}
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from bbs where seqno < "+seqNo+" order by seqno desc");
			
			for(int i = 0; i < 5 ;i++) {
				
				if(!rs.next()) break;
				list.setSeqNo(i, rs.getInt("seqno"));
				list.setTitle(i, rs.getString("title"));
				list.setWriter(i, rs.getString("id"));
			
			}
			
			if(!rs.next()) {
				list.setLastPage(true);
			}
			
		}catch(Exception e) {
			throw new ServletException("���������� ó���� ���ܹ߻�!");
		}finally {
			try{ stmt.close(); conn.close(); }catch(Exception e){}
		}
		return list;
	}
	
	private BBSShowList readPrevPage(int seqNo)	throws ServletException {
		
		BBSShowList list = new BBSShowList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			
			if(conn == null) {
				throw new ServletException("DB ���� ����!");
			}
			
			pstmt = conn.prepareStatement("select * from bbs where seqno > "+seqNo+" order by seqno desc", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.last()) {
				throw new ServletException("���������� �̵��Ұ�!");
			}
			
			int rows = rs.getRow();//������ ���� ��ȣ ����
			
			rs.absolute(rows - 4);//���� 4ĭ �̵�
		
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
			throw new ServletException("���� ������ �̵��� ����!");
		}finally {
			
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e){}
		}
		return list;
	}
	
	private BBSShowList readPage(int pageNo) throws ServletException {
		
		CrudProcess crud = new CrudProcess();
		List bbsList = crud.selectBBSListAll();
		BBSShowList showList = new BBSShowList();
		Iterator iterator = bbsList.iterator();
		
		if(pageNo > 1) {
			for(int cnt = 0; cnt < (pageNo-1)*5; cnt++) {
				iterator.next();
			}
		}
		
		for(int i = 0; i < 5; i++) {
			
			if(iterator.hasNext()) {
				
				BBSList bbs = (BBSList)iterator.next();
				showList.setSeqNo(i,bbs.getSeqno());
				showList.setTitle(i, bbs.getTitle());
				showList.setTitle(i, bbs.getTitle());
				showList.setWriter(i, bbs.getId());
				
			}else {break;}
	
		}
		
		if(!iterator.hasNext()) {
			showList.setLastPage(true);
		}
		
		if(pageNo == 1) {
			showList.setFirstPage(true);
		}
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try{
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
//			
//			if(conn == null) {
//				throw new ServletException("DB ���� ����!");
//			}
//			
//			pstmt = conn.prepareStatement("select * from bbs order by seqno desc", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(pageNo > 1) {
//				rs.absolute((pageNo-1)*5);
//			}
//		
//			for(int cnt = 0; cnt < 5; cnt++) {
//				
//				if(!rs.next()) break;
//				list.setSeqNo(cnt, rs.getInt("seqno"));
//				list.setTitle(cnt, rs.getString("title"));
//				list.setWriter(cnt, rs.getString("id"));
//				
//			}
//			
//			if(!rs.next()) {
//				list.setLastPage(true);
//			}
//			if(pageNo == 1) {
//				list.setFirstPage(true);
//			}
//			
//		}catch(Exception e) {
//			
//			e.printStackTrace();
//			throw new ServletException("������ �˻��� ����");
//		
//		}finally {
//			
//			try{
//				
//				pstmt.close();
//				conn.close();
//				
//			}catch(Exception e) {}
//			
//		}
		
		return showList;
	}

	private BBSShowList readDB() throws ServletException {
				
		CrudProcess crud = new CrudProcess();
		List bbsList = crud.selectBBSListAll();
		BBSShowList showList = new BBSShowList();
		Iterator iterator = bbsList.iterator();
		
		for(int i = 0; i < 5; i++) {
			if(iterator.hasNext()) {
				BBSList bbs = (BBSList)iterator.next();
				showList.setSeqNo(i,bbs.getSeqno());
				showList.setTitle(i, bbs.getTitle());
				showList.setTitle(i, bbs.getTitle());
				showList.setWriter(i, bbs.getId());
			}else {break;}
		}
		showList.setFirstPage(true);
		
		return showList;
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
