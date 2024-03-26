package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.dto.Guest;

@Controller
public class SpringResponseControllerRest {
	
	/****** response text [html] ******/
	@GetMapping(value = "/response_string", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String response_string() {
		return "Hello string for javascript ajax request[한글]";
	}
	
	@GetMapping(value = "/response_html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String response_html() {
		return "<h3>Hello string for javascript ajax request[한글]</h3><hr />";
	}
	
	@GetMapping(value = "/response_json", produces = "application/json;charset=UTF-8")
	public @ResponseBody Guest response_json() {
		return Guest.builder().guest_no(1)
							  .guest_name("KIM")
							  .guest_date("2024-03-26")
							  .guest_homepage("homepage")
							  .guest_title("title")
							  .guest_content("content")
							  .build();
	}
	
	@GetMapping(value = "/response_xml", produces = "text/xml;charset=UTF-8")
	public @ResponseBody Guest response_xml() {
		return Guest.builder().guest_no(1)
				.guest_name("KIM")
				.guest_date("2024-03-26")
				.guest_homepage("homepage")
				.guest_title("title")
				.guest_content("content")
				.build();
	}
	
}
