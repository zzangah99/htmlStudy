package ex1012.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TimerRequestListener
 *
 */
@WebListener
public class TimerRequestListener implements ServletRequestListener {
	long start, end;

    public TimerRequestListener() {
        System.out.println("TimerRequestListener constructor call ...");
    }

	
    public void requestDestroyed(ServletRequestEvent sre)  { 
        System.out.println("TimerRequestListener destroyed call ...");
        start = System.currentTimeMillis();
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("TimerRequestListener initialized call ...");
        end = System.currentTimeMillis();
        
        System.out.println("ÃÑ ¼Ò¿ä ms " + (end - start) + "ms");
    }
	
}
