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
	 * ������ ���۵� ��
	 */
    public void contextInitialized(ServletContextEvent e)  { 
         application = e.getServletContext();
         application.setAttribute("count", new AtomicInteger());	//�������� �信�� ${applicationScope.count}
    }
	
    
    /**
     * ������ ���۵� �� count ����
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         AtomicInteger at = (AtomicInteger)application.getAttribute("count");
         int nowCount = at.incrementAndGet();
         System.out.println("������ �� (���� ������ ��) = " + nowCount + "��");
    }

	/**
	 * ������ ����� �� count ����
	 */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 AtomicInteger at = (AtomicInteger)application.getAttribute("count");
         int nowCount = at.decrementAndGet();
         System.out.println("������ �� (���� ������ ��) = " + nowCount + "��");
    }


}
