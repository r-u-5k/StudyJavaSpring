package com.itwill.guest.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet("/guest_modify_form.do")
public class GuestModifyFormServlet extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * forward 시 상대 경로는 context root(/guest_model1.1) 이후 모든 디렉토리가 가능함
		 */
		String forwardPath = "/WEB-INF/views/guest_modify_form.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}
}
