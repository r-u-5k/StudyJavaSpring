package com.itwill.guest.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;

	public GuestController() {
		System.out.println("--> GuestController() 생성자");
	}

	@GetMapping("/guest_main")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}

	@GetMapping("/guest_list")
	public String guest_list(Model model) {
		String forwardPath = "";
		try {
			List<Guest> guestList = guestService.guestList();
			model.addAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

	@GetMapping("/guest_view")
	public String guest_view(@RequestParam(name = "guest_no") String no, Model model) {
		String forwardPath = "";
		try {
			Guest guest = guestService.guestDetail(Integer.parseInt(no));
			model.addAttribute("guest", guest);
			forwardPath = "forward:/WEB-INF/views/guest_view.jsp?guest_no=" + no;
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

	@GetMapping("/guest_write_form")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}

	@PostMapping("/guest_write_action")
	public String guest_write_action(@RequestParam(name = "guest_name") String name,
			@RequestParam(name = "guest_email") String email, @RequestParam(name = "guest_homepage") String homepage,
			@RequestParam(name = "guest_title") String title, @RequestParam(name = "guest_content") String content) {
		Guest writeGuest = Guest.builder().guestContent(content).guestEmail(email).guestHomepage(homepage)
				.guestName(name).guestTitle(title).build();
		try {
			guestService.guestWrite(writeGuest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/guest_list";
	}

	@PostMapping("/guest_modify_form")
	public String guest_modify_form(@RequestParam(name = "guest_no") String no, Model model) {
		try {
			Guest guest = guestService.guestDetail(Integer.parseInt(no));
			model.addAttribute("guest", guest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/WEB-INF/views/guest_modify_form.jsp";
	}

	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@RequestParam(name = "guest_no") String no,
			@RequestParam(name = "guest_name") String name, @RequestParam(name = "guest_email") String email,
			@RequestParam(name = "guest_homepage") String homepage, @RequestParam(name = "guest_title") String title,
			@RequestParam(name = "guest_content") String content) {
		Guest modifyGuest = Guest.builder().guestContent(content).guestEmail(email).guestHomepage(homepage)
				.guestName(name).guestNo(Integer.parseInt(no)).guestTitle(title).build();
		try {
			guestService.guestUpdate(modifyGuest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/guest_view?guest_no=" + no;
	}
	
	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam(name = "guest_no") String no, Model model) {
		try {
			guestService.guestDelete(Integer.parseInt(no));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/guest_list";
	}

	/*
	<<요청 url(command)>>
	/guest_main 		 --forward --> guest_main.jsp
	/guest_list 		 --forward --> guest_list.jsp
	/guest_view 		 --forward --> guest_view.jsp
	/guest_write_form    --forward --> guest_write_form.jsp
	/guest_write_action  --redirect--> guest_list
	/guest_modify_form   --forward --> guest_modify_form.jsp
	/guest_modify_action --redirect--> guest_view
	/guest_remove_action --redirect--> guest_list
	*/

}
