package com.itwill.guest.controller;

import java.io.IOException;
import java.util.List;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {
	private GuestService guestService;
	
	public GuestListServlet() throws Exception {
		guestService = new GuestService();
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * forward 시 상대 경로는 context root(/guest_model1.1) 이후 모든 디렉토리가 가능함
		 */
		String forwardPath = "";

		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기
		 * 2.GuestService객체생성
		 * 3.GuestService객체 guestList() 메쏘드호출
		 */
		try {
			List<Guest> guestList = guestService.guestList();
			request.setAttribute("guestList", guestList);
			forwardPath = "/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			forwardPath = "/WEB-INF/views/guest_error.jsp";
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}
}
