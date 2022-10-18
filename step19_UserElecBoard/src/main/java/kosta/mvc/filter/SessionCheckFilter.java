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
		//사전 처리 - 인증 여부 체크
		String key = request.getParameter("key");
		if(key==null || key.equals("elec")) {
			//인증된 사용자만 보드 접근 가능
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			if(session.getAttribute("loginUser")==null) {
				req.setAttribute("errorMsg", "로그인 후 이용 가능합니다");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return ;//함수를 빠져나가라. chain.doFilter를 실행시키지 않기 위해서 필수
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
