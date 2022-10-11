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
 * 	<param-value>�����α׷���</param-value>
 * </servlet>
 * 
 * <servlet-mapping>
 * 	<servlet-name>boardServlet</servlet-name>
 *	<url-pattern>/board</url-pattern>
 * <servlet-mapping>
 * 
 * xml���� �� �۾��ϴ� ��� annotation���� ����
 */
@WebServlet(
		urlPatterns = { "/board" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "�����α׷���"), 
				@WebInitParam(name = "content", value = "���ΰ� �ʿ��ؿ�")
		},
		loadOnStartup=1 )
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BoardDTO> boardList = new ArrayList<BoardDTO>();
	
	public BoardServlet() {
		System.out.println("BoardSErvlet ������ call");//loadOnStartup ������ ����� (�����ʱ�ȭ)�����ȴ�
	}
    
	/**
	 * �Խù� 3�� �ʱ�ȭ �ؼ� ServletContext ������ ����
	 */
	public void init() throws ServletException {
		System.out.println(1111);
		boardList.add(new BoardDTO(10, super.getInitParameter("subject"), super.getInitParameter("content")));
		boardList.add(new BoardDTO(20, "Spring", "�����ӿ�ũ"));
		boardList.add(new BoardDTO(30, "jQuery", "javaScript �淮�� ���̺귯��"));
		
		ServletContext application = super.getServletContext();
		application.setAttribute("boardList", boardList);	//�信�� ${applicationScope.boardList} �� ���
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post ������� ���۵� �ѱ� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		//�Ѿ���� ���� �޾Ƽ� BoardDTO�� ����� list�� �߰��Ѵ�
		String no = request.getParameter("no");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		boardList.add(new BoardDTO(Integer.parseInt(no), subject, content));
		
		//�̵�
		response.sendRedirect("center.jsp");
	}

}
