package ex1011.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SampleFilter implements Filter{
	public SampleFilter() {
		System.out.println("SampleFilter 생성자");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SampleFilter의 사전 처리");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SampleFilter의 사전 처리");
		
		//실제 타겟 대상 호출
		chain.doFilter(request, response);	//다음 filter 또는 servlet, jsp 호출
		
		System.out.println("SampleFilter의 사후 처리");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SampleFilter destroy() 호출");
	}
}
