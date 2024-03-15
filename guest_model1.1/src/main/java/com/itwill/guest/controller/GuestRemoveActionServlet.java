package com.itwill.guest.controller;

import java.io.IOException;

import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guest_remove_action.do")
public class GuestRemoveActionServlet extends HttpServlet {
	private GuestService guestService;
	
	public GuestRemoveActionServlet() {
	
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "";

		/*
		   GET방식이면 guest_main.jsp redirection
		   
		  0.요청객체encoding설정
		  1.파라메타받기(guest_no)
		  2.GuestService객체생성
		  3.GuestService객체 deleteGuest(guest_no) 메쏘드호출
		  4.guest_list.jsp로 redirection
		 */
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				//response.sendRedirect("guest_main.jsp");
				forwardPath = "redirect:guest_main.do";
			} else {
				String guest_noStr = request.getParameter("guest_no");
				GuestService guestService = new GuestService();
				int rowCount = guestService.guestDelete(Integer.parseInt(guest_noStr));
				forwardPath = "redirect:guest_list.do";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB_INF/views/guest_error.jsp";
		}

		/********** Forward or Redirect **********/
		/*
		 * forward -> forward:/WEB-INF/views/guest_view.jsp
		 * redirect -> redirect:guest_xxx.do
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		if (forwardOrRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else {
			response.sendRedirect(path);
		}

		/*****************************************/
	}
}
