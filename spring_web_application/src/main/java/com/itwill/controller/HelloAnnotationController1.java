package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
/*
 * Controller 객체 생성
 */
public class HelloAnnotationController1 {
	public HelloAnnotationController1() {
		System.out.println("HelloAnnotationController1() 생성자 호출");
	}
	/*
	 * HandlerMapping 객체에 등록
	 */
	@GetMapping("/hello1")
	public String hello(HttpServletRequest request) {
		System.out.println("HelloAnnotationController1().hello() 메서드 호출");
		request.setAttribute("msg", "Hello HelloAnnotationController1!");
		//return "forward:/WEB-INF/views/hello1.jsp";
		return "hello1"; // prefix, suffix 설정해둠
	}
	
}
