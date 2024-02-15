package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*
		 * 클라이언트 요청 URL
		 *   - http://localhost/search?searchKeyword=asdfsad
		 *   - http://localhost/search?searchKeyword=
		 *   - http://localhost/search
		 */
		
		/*
		 * 1. 요청 객체를 사용해서 요청 시 전송되는 쿼리 스트링에 있는 파라메타 받기
		 *    - 파라메타 이름은 input element의 name 속성과 일치
		 *       <input type="text" name="searchkeyword">
		 *    - search?searchkeyword=java   
		 */
		String searchKeyword = request.getParameter("searchKeyword");
		/*
		 * searchKeyword null --> search?
		 * searchKeyword "" --> search?searchKeyword=
		 */
		if (searchKeyword == null || searchKeyword.equals("")) {
			out.println("검색어 입력 없음<br>");
			out.println("<a href='05-00.search_form.html'>검색페이지</a>");
			return;
		}
		
		/*
		 * 2. 검색업무실행 --> Service 객체 사용
		 */
		
		
		/*
		 * 3. 클라이언트로 검색 결과 전송
		 */
		out.println("<h1>" + searchKeyword + " 검색 결과</h1><hr />");
		out.println("<ol>");
		int searchResultCount = (int) (Math.random() * 10);
		for (int i = 0; i < searchResultCount; i++) {
			out.println("<li>" + searchKeyword + "의 검색 결과");
		}
		out.println("</ol>");
		out.println("<a href='05-00.search_form.html'>검색페이지</a>");
		
	}
}
