package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationMultiRequestMappingController {
	@RequestMapping("/hello3")
	public String hello3() {
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	@GetMapping("/hello4")
	public String hello4() {
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	@GetMapping("/hello5")
	public String hello5() {
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	
	/**************** Redirect ****************/
	@GetMapping("/hello_redirect_servlet")
	public String helloRedirectServlet() {
		return "redirect:hello_redirected_servlet";
	}
	@GetMapping("/hello_redirected_servlet")
	public String helloRedirectedServlet() {
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
	}
	
	/**************** Forward ****************/
	@GetMapping("/hello_servlet_forward")
	public String helloServletForward() {
		return "forward:hello_servlet_forwarded";
	}
	@GetMapping("hello_servlet_forwarded")
	public String helloServletForwarded() {
		return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp";
	}
	
}
