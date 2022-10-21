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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestLib")
public class SuggestServletLib extends HttpServlet {
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
		//2. json 형태로 전송 [{key:value, key:value ...}] or [{value, value, ...}]
		//lib를 추가해서 제공하는 메소드를 이용
		JSONArray arr = JSONArray.fromObject(list);
		
		
		//front단으로 응답(데이터 전송)
		PrintWriter out = response.getWriter();
		out.println(arr);
	}

}
