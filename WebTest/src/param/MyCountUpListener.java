package param;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class MyCountUpListener
 *
 */
public class MyCountUpListener implements ServletRequestListener {

	private static long reqCount;
	
    /**
     * Default constructor. 
     */
    public MyCountUpListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
/*
    	reqCount = reqCount++;
    	ServletContext sc = arg0.getServletContext();
    	sc.setAttribute("TOTAL_COUNT", reqCount);
    	�̷��� ����� ���������� ó������ �ʴ´�.
    	�׷��Ƿ� ����ȭ�� ����ؾ��Ѵ�.
		�޼��� �տ� ����ȭó���ϸ� �������� ������
		Ư���� ��ü���� ����ȭó���� ����� �Ѵ�.
*/
    	ServletContext sc = arg0.getServletContext();
    	
    	synchronized (sc) {
    		sc.setAttribute("TOTAL_COUNT", reqCount++);	
		}
    	
    }
	
}
