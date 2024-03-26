package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloAnnotationController2 {
	public HelloAnnotationController2() {
		System.out.println("HelloAnnotationController2() 생성자 호출");
	}
	@GetMapping("/hello2")
	public String hello(HttpServletRequest request) {
		System.out.println("HelloAnnotationController2().hello() 메서드 호출");
		request.setAttribute("msg", "Hello HelloAnnotationController2!");
		return "forward:/WEB-INF/views/hello2.jsp";
	}
}
