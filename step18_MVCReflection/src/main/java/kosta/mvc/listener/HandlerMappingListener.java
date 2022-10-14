package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

/**
 * 서버가 시작될 때 각 Controller의 구현 클래스를 미리 생성해서 Map에 저장한 후
 * ServletContext 영역에 map을 저장한다
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent sce) {}

	
    public void contextInitialized(ServletContextEvent e)  { 
         //생성해야하는 객체들의 정보를 가지고 있는 ~.properties 파일을 로딩
    	ResourceBundle rb = ResourceBundle.getBundle("actionMapping");//resources 폴더는 배포파일에는 생기지 않기 때문에 폴더 경로를 적지 않는다
    	
    	/*
    	 * String의 문자열을 Controller라는 객체로 생성해야한다
    	 * : Class<?>는 어떤 객체가 가지고 있는 필드, 생성자, 메소드의 정보를 동적으로 가져올 수 있도록 도와주는 각체
    	 * - reflection 개념
    	 * : reflection 개념은 동적으로 즉, 실행 도중에 필요한 객체를 적절하게 생성하고 그 객체가 가지고 있는
    	 * 생성자나 메소드를 동적으로 호출할 수 있도록 도와주는 개념을 Reflection 이라 한다
    	 * 자바에서 이러한 개념을 적용해 놓은 API가 Class<?> 이다
    	 * */
    	try{
    		Map<String, Controller> map = new HashMap<String, Controller>();
    		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>(); //Class<?> 을 application에 저장하기 위한 맵
    		
    		for(String key : rb.keySet()) {
    			String value = rb.getString(key);
    		
    			Class<?> className = Class.forName(value);
    			Controller con = (Controller)className.getDeclaredConstructor().newInstance();
    			
    			map.put(key, con);
    			clzMap.put(key, className);
    			
    			System.out.println(key+" = "+con);
    		}
    		//현재 프로젝트의 모든 영역에서 map을 사용할 수 있도록 ServletContext 영역에 저장한다
    		ServletContext application = e.getServletContext();
    		application.setAttribute("map", map);
    		application.setAttribute("clzMap", clzMap);
    		application.setAttribute("path", application.getContextPath());//${path}
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
	
}
