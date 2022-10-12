package ex1012.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        System.out.println("SessionListener ������ call ...");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("SessionListener sessionCreated call ...");
    }

	/**
     * ���� ����� �� ȣ��
     * 1) session.invalidate();
     * 2) session timeout �Ǿ��� ��
     * 3) �������� x�� Ŭ������ �� ȣ����� �ʴ´�
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("SessionListener sessionDestroyed call ...");
    }
	
}
