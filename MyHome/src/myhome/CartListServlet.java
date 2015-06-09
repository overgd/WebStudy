package myhome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.s;

/**
 * Servlet implementation class CartListServlet
 */
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		
		if(cart != null) { //��ٱ��ϰ� ������
			//��ٱ��Ͽ� �ִ� ��ǰ�ڵ�� ��ȸ
			//��ȸ ����� �� ��´�.
			CartList cartList = readDB(cart);	

			request.setAttribute("CART_LIST", cartList);

		}else {	 //��ٱ��ϰ� ������
			request.setAttribute("CART_LIST", null);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=cartListView.jsp");
		rd.forward(request, response);
		
	}
	
	private CartList readDB(Cart cart) throws ServletException {
		
		CartList cartList = new CartList();
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hr", "hr");
			
			if(conn == null) throw new Exception("DB���� ����!");
			
			stmt = conn.createStatement();
			
			int itemNumber = cart.getSize(); //��ٱ��� �׸񰹼�
			
			for(int i = 0; i < itemNumber ;i++) {
				
				String code = cart.getCode(i);
				ResultSet rs = stmt.executeQuery("select name, price from goods where code="+code);
				if(!rs.next()) {
					throw new ServletException("�ش� ��ǰ�� �����ϴ�.");
				}
				
				String name = rs.getString("name");
				int price = rs.getInt("price");
				
				cartList.setCode(i, Integer.parseInt(code));
				cartList.setname(i, name);
				cartList.setPrice(i, price);
				int number = cart.getNumber(i);
				cartList.setNumber(i, number);
				
			}
						
		}catch(Exception e) {
			
			throw new ServletException("��ǰ �˻� �� ����!");
			
		}finally {
			
			try{
				stmt.cancel();
				conn.close();
			}catch(Exception e) {
				
			}
			
		}
		return cartList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
