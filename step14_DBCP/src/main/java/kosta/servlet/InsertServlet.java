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
		String errMsg = "등록되지 않았습니다";
		boolean isRedirect = false; //true이면 redirect 방식, false이면 forward 방식
		
		//넘어오는 값 받기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		//유효성 체크
		if(id==null || id.equals("") || pwd==null || pwd.equals("") || name==null || name.equals("") || age==null || age.equals("") || 
				phone==null || phone.equals("") || addr==null || addr.equals("")) {
			//오류가 있다는 의미
			errMsg = "입력값 정보가 충분하지 않습니다.\\n다시 확인해주세요";
		} else {
			
			//중복 체크
			MemberDAO dao = new MemberDAOImpl();
			if(dao.duplicateCheckById(id)) {
				errMsg = id+"는 이미 사용중입니다";
			}else {
				//등록하기
				Member member = new Member(id, pwd, name, Integer.parseInt(age), phone, addr, null);
				if(dao.insert(member) > 0) {
					url = "selectAll";
					isRedirect = true;
				}
			}
		}
		
		//성공하면 selectAll 서블릿으로 이동 - redirect 방식	
		//오류 있으면 오류 메시지를 scope에 저장하고 error.jsp 이동 - format
		if(isRedirect) {
			resp.sendRedirect(url);
		}else {
			req.setAttribute("errMsge", errMsg);
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

}
