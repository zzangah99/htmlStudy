package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("InsertController 호출 완료");
		
		//service 호출 -> dao 호출 -> 등록 완료되면 redirect 방식으로 전체 검색으로 이동
		
		ModelAndView mv = new ModelAndView("front?key=select",true);
		
		return mv;
	}

}
