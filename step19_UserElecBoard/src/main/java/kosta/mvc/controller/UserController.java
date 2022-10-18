package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.service.UserService;
import kosta.mvc.service.UserServiceImpl;

public class UserController implements Controller {
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * �α��� ���
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//�� ���� ���۵Ǵ� ���� �޴´�
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		//���� ȣ��
		UserDTO dbDTO = userService.loginCheck(new UserDTO(userId, pwd));
		
		//�α��� �����ϸ� ���ǿ� ���� ���� - ${loginUser} / ${loginName}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO);
		session.setAttribute("loginName", dbDTO.getName());
		
		//index.jsp �̵� -> redirect ���
		return new ModelAndView("index.jsp",true);
	}
	
	/**
	 * �α׾ƿ� ���
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��� ������ ������ ����
		request.getSession().invalidate();
		return new ModelAndView("index.jsp",true);
	}
}
