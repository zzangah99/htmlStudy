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
		//�Խù� �ʱ�� ������ 3�� �⺻ ����
		list = new ArrayList<BoardDTO>();
		list.add(new BoardDTO(1,"test1"));
		list.add(new BoardDTO(2,"test2"));
		
		//��� ������ �����ؼ� ����� �� �ֵ��� list�� ServletContext ������ ����
		ServletContext application = super.getServletContext();
		application.setAttribute("list", list); //�信�� ${applicationScope.list}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�Ѿ���� 3���� �� �ޱ� (��ȣ, ����, ����)
		
		//list�� ����
		//list.add(???);
		
		//index ������ �̵� -> top.location.href="index.jsp";
	}
}
