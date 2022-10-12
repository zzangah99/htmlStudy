package ex1012.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserAccessCounterListener
 *
 */
@WebListener
public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {
	ServletContext application;
	
    public UserAccessCounterListener() {
        System.out.println("UserAccessCounterListener constructor call ...");
    }

		
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
	 * 서버가 시작될 때
	 */
    public void contextInitialized(ServletContextEvent e)  { 
         application = e.getServletContext();
         application.setAttribute("count", new AtomicInteger());	//언제든지 뷰에서 ${applicationScope.count}
    }
	
    
    /**
     * 세션이 시작될 때 count 증가
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         AtomicInteger at = (AtomicInteger)application.getAttribute("count");
         int nowCount = at.incrementAndGet();
         System.out.println("증가한 후 (현재 접속자 수) = " + nowCount + "명");
    }

	/**
	 * 세션이 종료될 때 count 감소
	 */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 AtomicInteger at = (AtomicInteger)application.getAttribute("count");
         int nowCount = at.decrementAndGet();
         System.out.println("감소한 후 (현재 접속자 수) = " + nowCount + "명");
    }


}
