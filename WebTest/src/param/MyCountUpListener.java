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
    	이렇게 만들면 동시접속이 처리되지 않는다.
    	그러므로 동기화를 사용해야한다.
		메서드 앞에 동기화처리하면 느려지기 때문에
		특정한 개체에만 동기화처리를 해줘야 한다.
*/
    	ServletContext sc = arg0.getServletContext();
    	
    	synchronized (sc) {
    		sc.setAttribute("TOTAL_COUNT", reqCount++);	
		}
    	
    }
	
}
