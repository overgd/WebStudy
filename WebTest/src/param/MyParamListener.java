package param;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import june05.Dog;

/**
 * Application Lifecycle Listener implementation class MyParamListener
 *
 */
public class MyParamListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyParamListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    	ServletContext sc = arg0.getServletContext();
    	String str = sc.getInitParameter("pumjong");
    	Dog dog = new Dog(str);
    	sc.setAttribute("my_dog", dog);
    	
    }
	
}
