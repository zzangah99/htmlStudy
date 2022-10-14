package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SelectController 호출 완료");
		
		//service 호출 -> dao 호출 -> 검색 결과를 영속성에 저장하고 결과뷰로 이동
		
		request.setAttribute("message", "전체검색결과");
		
		ModelAndView mv = new ModelAndView("selectResult.jsp");
		return mv;
	}

}
