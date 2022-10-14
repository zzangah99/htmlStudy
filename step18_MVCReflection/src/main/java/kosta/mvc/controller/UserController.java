package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원 관리에 관한 Controller
 *
 */
public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	
	/**
	 * 로그인
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UesrController login 호출");
		
		//service -> dao 호출
		
		//로그인 성공하면 세션에 정보 저장
		HttpSession session = request.getSession();
		session.setAttribute("sessionMessage", "로그인 된 정보입니다");
		
		return new ModelAndView("user/login.jsp", true);//redirect 방식으로 이동
	}
	
	
	/**
	 * 회원 정보 수정
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UesrController update 호출");
		
		//service -> dao 호출
		request.setAttribute("message", "수정 완료되었습니다");
		
		return new ModelAndView("user/update.jsp");//forward 방식으로 이동
	}
	
	
	/**
	 * 가입
	 */
	
	
	
	/**
	 * 로그아웃
	 */

}
