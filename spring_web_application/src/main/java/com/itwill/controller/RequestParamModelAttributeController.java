package com.itwill.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestParamModelAttributeController {
	@GetMapping("/parameter_guest_write_form")
	public String paramGuestWriteForm() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}

	@PostMapping("/parameter_guest_write_action")
	public String paramGuestWriteAction(@RequestParam String guest_name,
			@RequestParam String guest_email, @RequestParam(name = "guest_homepage") String homepage,
			@RequestParam(name = "guest_title") String title, @RequestParam(name = "guest_content") String content) {
		Guest writeGuest = Guest.builder().guest_content(content)
				.guest_email(guest_email).guest_homepage(homepage)
				.guest_name(guest_name).guest_title(title).build();
		System.out.println("@RequestParam --> writeGuest: " + writeGuest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
	@PostMapping("model_attribute_guest_write_action")
	public String modelAttGuestWriteAction(/* @ModelAttribute */ Guest guest) {
		System.out.println("--> writeGuest: " + guest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}

	@GetMapping("/user/list")
	public String getUserList() {
		return "forward:/WEB-INF/views/user/list.jsp";
	}

	@GetMapping("/user/view")
	public String getUserView() {
		return "forward:/WEB-INF/views/user/view.jsp";
	}
}
