package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggest")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String [] words = {
		"java Programming","java Script", "java 하는중", "java 졸려", "java칩프라푸치노", "jQuery", "Ajax", "Spring Framework",
		"Sprite", "Scratch", "String", "Sleepy ..."
	};
	
	
	/**
	 * 인수로 전달된 단어로 시작하는 단어를 찾아서 List에 저장한 후 리턴하는 메소드
	 */
	public List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		
		return list;
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //깨지지 않게 인코딩 처리
		String keyWord = request.getParameter("keyWord");
		List<String> list = this.search(keyWord);
		
		//javaScript가 알 수 있는 데이터 형식으로 변환(text, xml, html, json)
		//1. text 형태로 전송 - 개수|단어,단어,단어
		String str = list.size()+"|";
		for(int i=0; i<list.size(); i++) {
			if(list.size() == (i+1)) {
				str += list.get(i);
			} else {
				str += list.get(i)+",";
			}
			
		}
		
		//front단으로 응답(데이터 전송)
		PrintWriter out = response.getWriter();
		out.println(str);
	}

}
