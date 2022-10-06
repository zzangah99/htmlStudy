package ex1006.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex1006.dto.BoardDTO;

public class TestServlet extends HttpServlet{
	List<BoardDTO> list;
	
	@Override
	public void init() throws ServletException {
		//게시물 초기시 데이터 3개 기본 설정
		list = new ArrayList<BoardDTO>();
		list.add(new BoardDTO(1,"test1"));
		list.add(new BoardDTO(2,"test2"));
		
		//모든 유저가 공유해서 사용할 수 있도록 list를 ServletContext 영역에 저장
		ServletContext application = super.getServletContext();
		application.setAttribute("list", list); //뷰에서 ${applicationScope.list}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//넘어오는 3개의 값 받기 (번호, 제목, 내용)
		
		//list에 저장
		//list.add(???);
		
		//index 페이지 이동 -> top.location.href="index.jsp";
	}
}
