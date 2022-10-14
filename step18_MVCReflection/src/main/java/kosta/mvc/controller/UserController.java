package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ȸ�� ������ ���� Controller
 *
 */
public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	
	/**
	 * �α���
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UesrController login ȣ��");
		
		//service -> dao ȣ��
		
		//�α��� �����ϸ� ���ǿ� ���� ����
		HttpSession session = request.getSession();
		session.setAttribute("sessionMessage", "�α��� �� �����Դϴ�");
		
		return new ModelAndView("user/login.jsp", true);//redirect ������� �̵�
	}
	
	
	/**
	 * ȸ�� ���� ����
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UesrController update ȣ��");
		
		//service -> dao ȣ��
		request.setAttribute("message", "���� �Ϸ�Ǿ����ϴ�");
		
		return new ModelAndView("user/update.jsp");//forward ������� �̵�
	}
	
	
	/**
	 * ����
	 */
	
	
	
	/**
	 * �α׾ƿ�
	 */

}
