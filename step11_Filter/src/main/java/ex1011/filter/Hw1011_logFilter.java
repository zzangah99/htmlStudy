package ex1011.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet Filter implementation class Hw1011_log
 */
@WebFilter("/*")
public class Hw1011_logFilter implements Filter {
	private Log log;

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String ip = request.getRemoteAddr();
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURL().toString();
		log.debug("ip = " + ip + " , url = " + url);
		
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		log.debug("ÃÑ ¼Ò¿ä ms : " + (end-start) + "ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log = LogFactory.getLog(super.getClass());
		System.out.println("log = "+log);
	}

}
