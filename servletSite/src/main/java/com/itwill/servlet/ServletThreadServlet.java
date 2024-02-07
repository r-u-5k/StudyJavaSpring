package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletThreadServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currendThreadName = Thread.currentThread().getName();
		System.out.println(request.getRemoteAddr() + "님의 요청에 의해 " + 
						   request.getLocalAddr() + " 서버에서 할당된 스레드는 " + 
						   currendThreadName + "입니다.");
		System.out.println(request.getLocalAddr() + " 서버에서" + request.getRemoteAddr() + "님의 브라우저로 응답합니다");
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(request.getRemoteAddr() + "님의 요청에 의해 " + 
				   request.getLocalAddr() + " 서버에서 할당된 스레드는 " + 
				   currendThreadName + "입니다.");
		out.println(request.getLocalAddr() + " 서버에서" + request.getRemoteAddr() + "님의 브라우저로 응답합니다");
		
		return;
	}

}
