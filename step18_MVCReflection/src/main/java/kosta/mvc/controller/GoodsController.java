package kosta.mvc.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 상품 관련 Controller
 */
public class GoodsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	
	/**
	 * 상품 목록 가져오기
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController list 호출");
		
		request.setAttribute("goodsList", Arrays.asList("사과","딸기","포도"));
		return new ModelAndView("goods/list.jsp");//forward 이동
	}
	
	
	/**
	 * 상품 등록
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GoodsController insert 호출");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
