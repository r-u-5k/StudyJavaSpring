package com.itwill.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SpringModelController {
	@GetMapping("/model_request")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "Request Data");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@GetMapping("/model_model")
	public String modelModel(Model model) {
		model.addAttribute("model", "Model Data");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@GetMapping("/model_map")
	public String modelMap(Map map) {
		map.put("map", "Map Data");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@GetMapping("/model_modelmap")
	public String modelModelMap(ModelMap modelMap) {
		modelMap.addAttribute("modelmap", "ModelMap Data");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@GetMapping("/model_modelandview")
	public ModelAndView modelModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/views/spring_model.jsp");
		modelAndView.addObject("modelandview", "ModelAndView Data");
		return modelAndView;
	}
	@GetMapping("/model_all")
	public String modelAll(HttpServletRequest request, Model model, Map map, ModelMap modelMap) {
		request.setAttribute("req", "Request Data");
		model.addAttribute("model", "Model Data");
		map.put("map", "Map Data");
		modelMap.addAttribute("modelmap", "ModelMap Data");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
}
