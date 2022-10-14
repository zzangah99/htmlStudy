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
 * ������ ���۵� �� �� Controller�� ���� Ŭ������ �̸� �����ؼ� Map�� ������ ��
 * ServletContext ������ map�� �����Ѵ�
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent sce) {}

	
    public void contextInitialized(ServletContextEvent e)  { 
         //�����ؾ��ϴ� ��ü���� ������ ������ �ִ� ~.properties ������ �ε�
    	ResourceBundle rb = ResourceBundle.getBundle("actionMapping");//resources ������ �������Ͽ��� ������ �ʱ� ������ ���� ��θ� ���� �ʴ´�
    	
    	/*
    	 * String�� ���ڿ��� Controller��� ��ü�� �����ؾ��Ѵ�
    	 * : Class<?>�� � ��ü�� ������ �ִ� �ʵ�, ������, �޼ҵ��� ������ �������� ������ �� �ֵ��� �����ִ� ��ü
    	 * - reflection ����
    	 * : reflection ������ �������� ��, ���� ���߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü�� ������ �ִ�
    	 * �����ڳ� �޼ҵ带 �������� ȣ���� �� �ֵ��� �����ִ� ������ Reflection �̶� �Ѵ�
    	 * �ڹٿ��� �̷��� ������ ������ ���� API�� Class<?> �̴�
    	 * */
    	try{
    		Map<String, Controller> map = new HashMap<String, Controller>();
    		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>(); //Class<?> �� application�� �����ϱ� ���� ��
    		
    		for(String key : rb.keySet()) {
    			String value = rb.getString(key);
    		
    			Class<?> className = Class.forName(value);
    			Controller con = (Controller)className.getDeclaredConstructor().newInstance();
    			
    			map.put(key, con);
    			clzMap.put(key, className);
    			
    			System.out.println(key+" = "+con);
    		}
    		//���� ������Ʈ�� ��� �������� map�� ����� �� �ֵ��� ServletContext ������ �����Ѵ�
    		ServletContext application = e.getServletContext();
    		application.setAttribute("map", map);
    		application.setAttribute("clzMap", clzMap);
    		application.setAttribute("path", application.getContextPath());//${path}
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
	
}
