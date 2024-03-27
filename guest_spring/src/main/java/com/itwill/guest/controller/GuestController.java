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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "guest_main";
	}

	@GetMapping("/guest_list")
	public String guest_list(Model model) {
		String forwardPath = "";
		try {
			List<Guest> guestList = guestService.guestList();
			model.addAttribute("guestList", guestList);
			forwardPath = "guest_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "guest_error";
		}
		return forwardPath;
	}

	@GetMapping("/guest_write_form")
	public String guest_write_form() {
		return "guest_write_form";
	}

	@PostMapping("/guest_write_action")
	public String guest_write_action(@RequestParam(name = "guest_name") String name,
			@RequestParam(name = "guest_email") String email, @RequestParam(name = "guest_homepage") String homepage,
			@RequestParam(name = "guest_title") String title, @RequestParam(name = "guest_content") String content,
			RedirectAttributes redirectAttributes) {
		Guest writeGuest = Guest.builder().guestContent(content).guestEmail(email).guestHomepage(homepage)
				.guestName(name).guestTitle(title).build();
		try {
			int no = guestService.guestWrite(writeGuest);
			redirectAttributes.addAttribute("guest_no", no);
			return "redirect:guest_view";
		} catch (Exception e) {
			e.printStackTrace();
			return "guest_error";
		}
	}

	/*
	 * parameter에 guest_no가 존재하면
	 */
	@GetMapping("/guest_view")
	public String guest_view(@RequestParam(name = "guest_no") int no, Model model) {
		try {
			Guest guest = guestService.guestDetail(no);
			model.addAttribute("guest", guest);
			return "guest_view";
		} catch (Exception e) {
			e.printStackTrace();
			return "guest_error";
		}
	}

	/*
	 * parameter에 guest_no가 존재하지 않으면
	 */
	@GetMapping(value = "/guest_view", params = "!guest_no")
	public String guest_view() {
		return "redirect:guest_list";
	}

	@PostMapping("/guest_modify_form")
	public String guest_modify_form(@RequestParam(name = "guest_no") int no, Model model) {
		try {
			Guest guest = guestService.guestDetail(no);
			model.addAttribute("guest", guest);
			return "guest_modify_form";
		} catch (Exception e) {
			e.printStackTrace();
			return "guest_error";
		}
	}

	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@RequestParam(name = "guest_no") int no,
			@RequestParam(name = "guest_name") String name, @RequestParam(name = "guest_email") String email,
			@RequestParam(name = "guest_homepage") String homepage, @RequestParam(name = "guest_title") String title,
			@RequestParam(name = "guest_content") String content, RedirectAttributes redirectAttributes) {
		Guest modifyGuest = Guest.builder().guestContent(content).guestEmail(email).guestHomepage(homepage)
				.guestName(name).guestNo(no).guestTitle(title).build();
		try {
			guestService.guestUpdate(modifyGuest);
			redirectAttributes.addAttribute("guest_no", no);
			return "redirect:guest_view";
		} catch (Exception e) {
			e.printStackTrace();
			return "guest_error";
		}

	}

	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam(name = "guest_no") int no, Model model) {
		try {
			guestService.guestDelete(no);
			return "redirect:guest_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "guest_error";
		}
	}

	@GetMapping(value = { "/guest_modify_form", "/guest_modify_action", "/guest_remove_action", "/guest_write_action" })
	public String guest_get() {
		return "redirect:guest_main";
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
