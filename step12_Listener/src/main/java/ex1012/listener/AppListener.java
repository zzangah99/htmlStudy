package ex1012.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener{
	
	//web.xml�� ������ ���
	public AppListener() {
		System.out.println("AppListener ������ ȣ�� ...");
	}


	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("AppListener Initialized call ...");
		
		//�� ���� �����ڵ带 ��� �������� ����� �� �ֵ�� �̸� map �����Ѵ�
		Map<String, String> map = new HashMap<String, String>();
		map.put("kr", "���ѹα�");
		map.put("us", "�̱�");
		map.put("fr", "������");
		map.put("cn", "�߱�");
		map.put("jp", "�Ϻ�");
		
		//����� map�� ���� Ŭ���������� ����� �� �ֱ� ������ ServletContext ������ �����ؾ��Ѵ�
		ServletContext application = e.getServletContext();
		application.setAttribute("nationMap", map);//��� �� �������� ${applicationScope.nationMap}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener contextDestroyed call ...");
	}
}
