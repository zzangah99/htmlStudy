package kosta.mvc.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * ��ǰ ���� Controller
 */
public class GoodsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	
	/**
	 * ��ǰ ��� ��������
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController list ȣ��");
		
		request.setAttribute("goodsList", Arrays.asList("���","����","����"));
		return new ModelAndView("goods/list.jsp");//forward �̵�
	}
	
	
	/**
	 * ��ǰ ���
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController insert ȣ��");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
