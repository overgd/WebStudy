package mat;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatServ
 */
public class MatServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatServ() {
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
		request.setCharacterEncoding("euc-kr");
		
		String gu = request.getParameter("gu");
		
		MatList ml = new MatList();
		List jips = ml.getJips(gu);
		
		String admin = getServletContext().getInitParameter("AdminAddress");
		String mat = getServletConfig().getInitParameter("MatName");
				
		request.setAttribute("ADMIN", admin);
		request.setAttribute("MAT", mat);
		request.setAttribute("RESULT", jips);
		
		RequestDispatcher rd = request.getRequestDispatcher("Matshow.jsp");
		
		rd.forward(request, response);
	}

}
