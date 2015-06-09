package myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddItemToCartServlet
 */
public class AddItemToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("CODE");
		
		if(code == null) {
			throw new ServletException("��ǰ�ڵ尡 �������� �ʴ´�");
		}
		
		HttpSession session = request.getSession();
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart == null) {
			cart = new Cart(); //���ǿ� ��ٱ��ϰ� ������ ����
		}
		
		cart.addItem(code, 1); //��ٱ��Ͽ� ��ǰ�ڵ�� ������ ��´�.
		session.setAttribute("CART", cart);
		response.sendRedirect("addItemToCartResult.jsp?ITEM_NUM="+1+"&CODE="+code);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
