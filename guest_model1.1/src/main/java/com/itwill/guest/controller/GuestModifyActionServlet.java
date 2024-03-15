package com.itwill.guest.controller;

import java.io.IOException;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guest_modify_action.do")
public class GuestModifyActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "/WEB-INF/views/guest_modify_action.jsp";

		/*
		GET방식이면 guest_main.jsp redirection
		
			0.요청객체encoding설정
			1.파라메타받기(guest_no,guest_name,guest_email,guest_homepage,guest_title,guest_content)
			 Guest객체생성
			2.GuestService객체생성
			3.GuestService객체 updateGuest(Guest객체) 메쏘드호출
			4.guest_view.jsp로 redirection
		*/
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			} else {
				String guest_no = request.getParameter("guest_no");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				GuestService guestService = new GuestService();
				int rowCount = guestService.guestUpdate(Guest.builder().guestNo(Integer.parseInt(guest_no))
						.guestName(guest_name).guestEmail(guest_email).guestHomepage(guest_homepage)
						.guestTitle(guest_title).guestContent(guest_content).build());

				forwardPath = "redirect:guest_view.do?guest_no=" + guest_no;
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
