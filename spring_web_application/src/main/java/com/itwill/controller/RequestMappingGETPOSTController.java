package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class RequestMappingGETPOSTController {
	@GetMapping("/login")
	public String getLoginForm() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}

	@PostMapping("/login")
	public String postLoginAction(@RequestParam(name = "id") String id,
			@RequestParam(name = "password") String password, HttpSession session) {
		System.out.println("id: " + id);
		System.out.println("password: " + password);
		boolean isLogin = true;
		if (isLogin) {
			session.setAttribute("sUserId", id);
		}
		return "forward:/WEB-INF/views/post_login_result.jsp";
	}

}
