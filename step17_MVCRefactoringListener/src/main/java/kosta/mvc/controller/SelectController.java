package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SelectController ȣ�� �Ϸ�");
		
		//service ȣ�� -> dao ȣ�� -> �˻� ����� ���Ӽ��� �����ϰ� ������ �̵�
		
		request.setAttribute("message", "��ü�˻����");
		
		ModelAndView mv = new ModelAndView("selectResult.jsp");
		return mv;
	}

}
