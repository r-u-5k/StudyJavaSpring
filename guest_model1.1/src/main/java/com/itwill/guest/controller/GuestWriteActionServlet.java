package com.itwill.guest.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/guest_write_action.do")
public class GuestWriteActionServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * forward 시 상대 경로는 context root(/guest_model1.1) 이후 모든 디렉토리가 가능함
		 */
		String forwardPath = "/WEB-INF/views/guest_write_action.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}
}
