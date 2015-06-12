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
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		String writeid = request.getParameter("id");
		//DB에서 select를 하고 암호가 일치하면 삭제
		CrudProcess crud = new CrudProcess();
		
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writeid));
		
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=deleteForm_view.jsp");
		rd.forward(request, response);
		
	}

}
