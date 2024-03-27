package com.itwill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.user.User;
import com.itwill.user.UserService;

import jakarta.servlet.http.HttpSession;

/*
  /user_main 
  /user_write_form 
  /user_write_action 
  /user_login_form
  /user_login_action 
  /user_logout_action 
  /user_view 
  /user_modify_form
  /user_modify_action 
  /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//httpsession 사용?
	@GetMapping("/user_main")
	public String user_main() {
		return "user_main";
	}

	@GetMapping("/user_write_form")
	public String user_write_form() {
		return "user_write_form";
	}

	@PostMapping("/user_write_action")
	public String user_write_action(@RequestParam(name = "userId") String id,
			@RequestParam(name = "password") String password, @RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, RedirectAttributes redirectAttributes) throws Exception {
		int result = userService
				.create(User.builder().userId(id).email(email).name(name).password(password).email(email).build());
		if (result == 1) {
			redirectAttributes.addAttribute("msg", "Asdf");
			return "redirect:user_login_form";
		} else if (result == 0) {
			//msg? return은 어디로?
			return "user_write_form";
		} else {
			//msg? return은 어디로?
			return "user_write_form";
		}
	}

	@GetMapping("/user_login_form")
	public String user_login_form() {
		return "user_login_form";
	}

	@PostMapping("/user_login_action")
	public String user_login_action(@RequestParam(name = "userId") String id, @RequestParam("password") String password,
			Model model) throws Exception {
		userService.login(id, password);
		model.addAttribute("userId", id);
		return "redirect:user_main";
	}

	@PostMapping("/user_view")
	public String user_view(@RequestParam(name = "userId") String id, Model model,
			RedirectAttributes redirectAttributes) throws Exception {
		/******* login check ******/
		
		User user = userService.findUser(id);
		model.addAttribute("user", user);
		redirectAttributes.addAttribute("sUserId", id);
		return "user_view";
	}

	@PostMapping("/user_modify_form")
	public String user_modify_form(@RequestParam(name = "userId") String id, Model model) throws Exception {
		/******* login check ******/
		
		User user = userService.findUser(id);
		model.addAttribute("user", user);
		return "user_modify_form";
	}

	@PostMapping("/user_modify_action")
	public String user_modify_action(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "password") String password, @RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, RedirectAttributes redirectAttributes) throws Exception {
		/******* login check ******/
		
		userService.update(User.builder().userId(userId).email(email).password(password).name(name).build());
		redirectAttributes.addAttribute("userId", userId);
		return "user_view";
	}

	@PostMapping("/user_remove_action")
	public String user_remove_action(@RequestParam(name = "userId") String id) throws Exception {
		/******* login check ******/
		
		userService.remove(id);
		return "redirect:user_main";
	}

	@PostMapping("/user_logout_action")
	public String user_logout_action() {
		/******* login check ******/

		return "redirect:user_main";
	}

	@GetMapping(value = { "/user_write_action", "/user_login_action", "/user_view", "/user_modify_form",
			"/user_modify_action", "/user_remove_action", "/user_logout_action" })
	public String user_get() {
		return "redirect:user_main";
	}

}
