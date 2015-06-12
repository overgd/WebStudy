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
 * Servlet implementation class DeleteWritingServlet
 */
public class DeleteWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWritingServlet() {
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
		String password = request.getParameter("password");
		CrudProcess crud = new CrudProcess();
		Writing orgWriting = crud.selectOneWritingInfo(Integer.parseInt(writeid));
		
		if(orgWriting.getPassword().equals(password)){//암호 일치
			//DB삭제
			
			crud.deleteWritingInfo(Integer.parseInt(writeid));
			crud.deleteWritingContent(Integer.parseInt(writeid));
			
		}else {//암호 불일치
			request.setAttribute("id", writeid);
		}
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=delete_result.jsp");
		rd.forward(request, response);
	}

}
