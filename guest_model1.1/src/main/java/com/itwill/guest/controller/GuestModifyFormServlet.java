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

@WebServlet("/guest_modify_form.do")
public class GuestModifyFormServlet extends HttpServlet {
	private GuestService guestService;

	public GuestModifyFormServlet() throws Exception {
		guestService = new GuestService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		GET방식이면 guest_main.jsp redirection
		0.요청객체encoding설정
		1.gust_no 파라메타받기
		2.GuestService객체생성
		3.GuestService객체 selectByNo(guest_no) 메쏘드호출
		4.Guest 데이타를 form의 input element의  value  속성에 출력
		*/
		String forwardPath = "";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_list.do";
			} else {
				String guest_noStr = request.getParameter("guest_no");
				Guest guest = guestService.guestDetail(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
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
