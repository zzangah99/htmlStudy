package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UpdateController 호출 완료");
		
		//service 호출 -> dao 수정완료 후 결과뷰로 이동
		request.setAttribute("message", "수정 완료");
		
		return new ModelAndView("updateResult.jsp");
	}

}
