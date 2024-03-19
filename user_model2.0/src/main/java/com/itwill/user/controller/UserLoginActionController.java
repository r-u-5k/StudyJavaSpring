package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLoginActionController implements Controller {
	private UserService userService;

	public UserLoginActionController() throws Exception {
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:user_main.do";
			}
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

			int result = userService.login(userId, password);
			if (result == 0) {
				// 0: 아이디 존재 X
				String msg1 = userId + "는 존재하지 않는 아이디입니다.";
				request.setAttribute("msg1", msg1);
				forwardPath = "forward:/WEB-INF/views/user_login_form.jsp";
			} else if (result == 1) {
				// 1: 패스워드 불일치
				String msg2 = "패스워드가 일치하지 않습니다.";
				request.setAttribute("msg2", msg2);
				request.setAttribute("fuser", new User(userId, "", "", ""));
				forwardPath = "forward:/WEB-INF/views/user_login_form.jsp";
			} else if (result == 2) {
				// 2: 로그인 성공(세션)
				HttpSession session = request.getSession();
				session.setAttribute("sUserId", userId);
				forwardPath = "redirect:user_main.do";
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}

		return forwardPath;
	}
}
