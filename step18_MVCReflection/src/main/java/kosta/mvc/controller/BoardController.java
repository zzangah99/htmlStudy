package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * �Խ��ǿ� ���õ� Controller
 */
public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * �Խù� �˻�
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController list ȣ��");
		
		request.setAttribute("message", "�˻� ����Դϴ�");
		return new ModelAndView("board/list.jsp"); //forward
	}

	
	/**
	 * �󼼺���
	 */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController read ȣ��");
		
		return new ModelAndView("board/read.jsp", true); //redirect
	}
}
