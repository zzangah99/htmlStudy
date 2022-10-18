package kosta.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
@WebFilter("/front")
public class SessionCheckFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//���� ó�� - ���� ���� üũ
		String key = request.getParameter("key");
		if(key==null || key.equals("elec")) {
			//������ ����ڸ� ���� ���� ����
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			if(session.getAttribute("loginUser")==null) {
				req.setAttribute("errorMsg", "�α��� �� �̿� �����մϴ�");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return ;//�Լ��� ����������. chain.doFilter�� �����Ű�� �ʱ� ���ؼ� �ʼ�
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
