package myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyCartServlet
 */
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCartServlet() {
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
		
		String code = request.getParameter("CODE");
		String num = request.getParameter("NUMBER");
		String btnName = request.getParameter("BTNS");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(btnName.equals("삭제")) {
			cart.deleteItem(code);
		}else if(btnName.equals("수정")) {
			cart.modifyItem(code, Integer.parseInt(num));
		}
		
		response.sendRedirect("cart_list");
		
	}
	
}
