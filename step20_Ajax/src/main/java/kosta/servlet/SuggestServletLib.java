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
		"java Programming","java Script", "java �ϴ���", "java ����", "javaĨ����Ǫġ��", "jQuery", "Ajax", "Spring Framework",
		"Sprite", "Scratch", "String", "Sleepy ..."
	};
	
	
	/**
	 * �μ��� ���޵� �ܾ�� �����ϴ� �ܾ ã�Ƽ� List�� ������ �� �����ϴ� �޼ҵ�
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
		response.setContentType("text/html;charset=UTF-8"); //������ �ʰ� ���ڵ� ó��
		String keyWord = request.getParameter("keyWord");
		List<String> list = this.search(keyWord);
		
		//javaScript�� �� �� �ִ� ������ �������� ��ȯ(text, xml, html, json)
		//2. json ���·� ���� [{key:value, key:value ...}] or [{value, value, ...}]
		//lib�� �߰��ؼ� �����ϴ� �޼ҵ带 �̿�
		JSONArray arr = JSONArray.fromObject(list);
		
		
		//front������ ����(������ ����)
		PrintWriter out = response.getWriter();
		out.println(arr);
	}

}
