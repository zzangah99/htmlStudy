package kosta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="error.jsp";
		String errMsg = "��ϵ��� �ʾҽ��ϴ�";
		boolean isRedirect = false; //true�̸� redirect ���, false�̸� forward ���
		
		//�Ѿ���� �� �ޱ�
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		//��ȿ�� üũ
		if(id==null || id.equals("") || pwd==null || pwd.equals("") || name==null || name.equals("") || age==null || age.equals("") || 
				phone==null || phone.equals("") || addr==null || addr.equals("")) {
			//������ �ִٴ� �ǹ�
			errMsg = "�Է°� ������ ������� �ʽ��ϴ�.\\n�ٽ� Ȯ�����ּ���";
		} else {
			
			//�ߺ� üũ
			MemberDAO dao = new MemberDAOImpl();
			if(dao.duplicateCheckById(id)) {
				errMsg = id+"�� �̹� ������Դϴ�";
			}else {
				//����ϱ�
				Member member = new Member(id, pwd, name, Integer.parseInt(age), phone, addr, null);
				if(dao.insert(member) > 0) {
					url = "selectAll";
					isRedirect = true;
				}
			}
		}
		
		//�����ϸ� selectAll �������� �̵� - redirect ���	
		//���� ������ ���� �޽����� scope�� �����ϰ� error.jsp �̵� - format
		if(isRedirect) {
			resp.sendRedirect(url);
		}else {
			req.setAttribute("errMsge", errMsg);
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

}
