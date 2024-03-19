package com.itwill.user.controller;


import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserLogoutActionController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/****** 로그인 체크 ******/
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		if (sUserId == null) {
			return "redirect:user_main.do";
		}
		/*************************/
		request.getSession().invalidate();
		return "redirect:user_main.do";
	}
}
