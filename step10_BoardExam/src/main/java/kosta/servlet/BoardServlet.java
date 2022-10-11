package kosta.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dto.BoardDTO;

/**
 * Servlet implementation class BoardServlet
 */

/** 
 * <sevlet>
 * 	<servlet-name>boardServlet</servlet-name>
 * 	<servlet-class>kosta.servlet.BoardServlet</servlet-class>
 * 	<param-name>subject</param-name>
 * 	<param-value>웹프로그래밍</param-value>
 * </servlet>
 * 
 * <servlet-mapping>
 * 	<servlet-name>boardServlet</servlet-name>
 *	<url-pattern>/board</url-pattern>
 * <servlet-mapping>
 * 
 * xml에서 위 작업하는 대신 annotation으로 진행
 */
@WebServlet(
		urlPatterns = { "/board" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "웹프로그래밍"), 
				@WebInitParam(name = "content", value = "공부가 필요해요")
		},
		loadOnStartup=1 )
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BoardDTO> boardList = new ArrayList<BoardDTO>();
	
	public BoardServlet() {
		System.out.println("BoardSErvlet 생성자 call");//loadOnStartup 지정을 해줘야 (사전초기화)생성된다
	}
    
	/**
	 * 게시물 3개 초기화 해서 ServletContext 영역에 저장
	 */
	public void init() throws ServletException {
		System.out.println(1111);
		boardList.add(new BoardDTO(10, super.getInitParameter("subject"), super.getInitParameter("content")));
		boardList.add(new BoardDTO(20, "Spring", "프레임워크"));
		boardList.add(new BoardDTO(30, "jQuery", "javaScript 경량의 라이브러리"));
		
		ServletContext application = super.getServletContext();
		application.setAttribute("boardList", boardList);	//뷰에서 ${applicationScope.boardList} 로 사용
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식으로 전송된 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//넘어오는 값을 받아서 BoardDTO로 만들고 list에 추가한다
		String no = request.getParameter("no");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		boardList.add(new BoardDTO(Integer.parseInt(no), subject, content));
		
		//이동
		response.sendRedirect("center.jsp");
	}

}
