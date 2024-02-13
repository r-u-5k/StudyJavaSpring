package com.itwill.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/lifecycle_counter", "/lifecycle_counter.itwill"})
@WebServlet("/lifecycle_counter")

public class LifeCycleCounterServlet extends HttpServlet {
	private int count;
	public LifeCycleCounterServlet() {
		System.out.println("0. LifeCycleCounterServlet 기본 생성자 [최초 요청 시 단 한 번 호출] 객체 주소: " + this);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("1. init 메서드 --> 생성자 호출 직후에 단 한 번 호출 [객체 초기화, 리소스 획득]");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2. service 메서드 실행 [요청 시마다 호출]: " + this);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("<center>");
		out.println("현재까지의 페이지뷰수 <font color=#0000FF> ");
		out.println(++count);
		out.println(" </font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		System.out.println("3. destroy 메서드 --> 서블릿 객체가 메모리에서 해제되기 직전에 호출 [리소스 반납]");
	}

}
