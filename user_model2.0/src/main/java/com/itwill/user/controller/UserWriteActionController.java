package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserWriteActionController implements Controller {
	private UserService userService;
	public UserWriteActionController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:user_main.do";
				return forwardPath;
			}
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			User newUser = new User(userId, password, name, email);

			int result = userService.create(newUser);
			if (result == 1) {
				forwardPath = "redirect:user_login_form.do";
			} else if (result == -1) {
				String msg = userId + "는 이미 존재하는 아이디입니다."; 
				request.setAttribute("msg", msg);
				request.setAttribute("fuser", newUser);
				forwardPath = "forward:/WEB-INF/views/user_write_form.jsp";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}

		return forwardPath;
	}

}
