package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle_image_counter")
public class LifeCycleCounterImageServlet extends HttpServlet {

	private int count;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("2.service 메쏘드실행(count=" + count + ") --> 클라이언트가 요청할 때마다 실행");
		/*
		 * 응답헤더의 contentType설정
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		count++;
		out.println("	<center>");
		out.println("현재까지의 페이지뷰수: ");
		/*
		  img 태그를 사용해서 출력
		*/
		String countStr = Integer.toString(count);
		for (int i = 0; i < countStr.length(); i++) {
			out.println("<img src='./image/" + countStr.charAt(i) + ".png'>");
		}

		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
