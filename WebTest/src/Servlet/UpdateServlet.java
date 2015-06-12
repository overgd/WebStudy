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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writeid = request.getParameter("id");
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writeid));
		String content = crud.selectWritingContent(Integer.parseInt(writeid));
		
		writing.setContent(content);
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=updateForm_view.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writeid = request.getParameter("id");
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writeid));
		String content = crud.selectWritingContent(Integer.parseInt(writeid));
		
		writing.setContent(content);
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=updateForm_view.jsp");
		rd.forward(request, response);
		
	}

}
