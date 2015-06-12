package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Writing;
import crud.CrudProcess;

/**
 * Servlet implementation class ReadServlet
 */
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writingid = request.getParameter("id");
		//위의 글번호로 DB검색
		CrudProcess crud = new CrudProcess();
		
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writingid));
		String content = crud.selectWritingContent(Integer.parseInt(writingid));
		
		writing.setContent(content);
		request.setAttribute("writing", writing);
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=read_view.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String writingid = request.getParameter("id");
		//위의 글번호로 DB검색
		CrudProcess crud = new CrudProcess();
		
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writingid));
		String content = crud.selectWritingContent(Integer.parseInt(writingid));
		
		writing.setContent(content);
		request.setAttribute("writing", writing);
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=read_view.jsp");
		rd.forward(request, response);
	}

}
