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
        System.out.println("SessionListener 생성자 call ...");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("SessionListener sessionCreated call ...");
    }

	/**
     * 세션 종료될 때 호출
     * 1) session.invalidate();
     * 2) session timeout 되었을 때
     * 3) 브라우저의 x를 클릭했을 때 호출되지 않는다
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("SessionListener sessionDestroyed call ...");
    }
	
}
