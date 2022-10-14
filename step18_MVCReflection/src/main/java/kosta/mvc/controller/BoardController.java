package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 게시판에 관련된 Controller
 */
public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 게시물 검색
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController list 호출");
		
		request.setAttribute("message", "검색 결과입니다");
		return new ModelAndView("board/list.jsp"); //forward
	}

	
	/**
	 * 상세보기
	 */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController read 호출");
		
		return new ModelAndView("board/read.jsp", true); //redirect
	}
}
