package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Condition;
import crud.CrudProcess;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int PAGE_SIZE = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CrudProcess crud = new CrudProcess();
		
//		List list = crud.selectBBSList(); //모든 게시글 검색
		//전체 글 갯수, 페이지 갯수, 시작 글 번호, 마지막 글 번호 
		
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		
		int curretnPage = Integer.parseInt(pageNum);
		int count = crud.selectPageCount();
		int totalPageCount = 0;	//전체 페이지 수
		int startRow = 0, endRow = 0;	//시작 행과 마지막 행 번호
		
		if(count > 0) {	//게시글이 존재하는 경우
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (curretnPage - 1) * PAGE_SIZE + 1;
			endRow = curretnPage * PAGE_SIZE;
			if(endRow > count) endRow = count;
		}
		
		Condition condition = new Condition();
		condition.setStartRow(startRow);
		condition.setEndRow(endRow);
		
		List list = crud.selectWritingInfoWithRange(condition);

		request.setAttribute("currentPage", curretnPage);
		request.setAttribute("PAGE_SIZE", PAGE_SIZE);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startRow", startRow);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=list_view.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CrudProcess crud = new CrudProcess();
		
//		List list = crud.selectBBSList(); //모든 게시글 검색
		//전체 글 갯수, 페이지 갯수, 시작 글 번호, 마지막 글 번호 
		
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		
		int curretnPage = Integer.parseInt(pageNum);
		int count = crud.selectPageCount();
		int totalPageCount = 0;	//전체 페이지 수
		int startRow = 0, endRow = 0;	//시작 행과 마지막 행 번호
		
		if(count > 0) {	//게시글이 존재하는 경우
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (curretnPage - 1) * PAGE_SIZE + 1;
			endRow = curretnPage * PAGE_SIZE;
			if(endRow > count) endRow = count;
		}
		
		Condition condition = new Condition();
		condition.setStartRow(startRow);
		condition.setEndRow(endRow);
		
		List list = crud.selectWritingInfoWithRange(condition);

		request.setAttribute("currentPage", curretnPage);
		request.setAttribute("PAGE_SIZE", PAGE_SIZE);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startRow", startRow);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=list_view.jsp");
		rd.forward(request, response);
		
	}

}
