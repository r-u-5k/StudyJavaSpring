package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.View;

import com.itwill.view.CustomView1;
import com.itwill.view.CustomView2;
import com.itwill.view.CustomView3;

@Controller
public class SpringReturnViewObjectController {
	@GetMapping("view1")
	public View returnView1(Model model) {
		model.addAttribute("msg", "모델 데이터");
		CustomView1 customView1 = new CustomView1();
		return customView1;
	}
	
	@GetMapping("view2")
	public CustomView2 returnView2() {
		CustomView2 customView2 = new CustomView2();
		customView2.setForwardPath("/xx");
		return customView2;
	}
	
	@GetMapping("view3")
	public CustomView3 returnView3() {
		CustomView3 customView3 = new CustomView3();
		customView3.setRedirectPath("/yy");
		return customView3;
	}
	
}
