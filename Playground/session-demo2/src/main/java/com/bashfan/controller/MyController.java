package com.bashfan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value= {"attr1","attr2"})
public class MyController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/test1")
	public ModelAndView mav() {
		ModelAndView mav = new ModelAndView("test1");
		mav.addObject("attr1", "this is attr1");
		mav.addObject("attr2", "this is attr2");
		return mav;
	}
	
	@RequestMapping("/test2")
	public String mav2() {
		return "test2";
	}
	
	@RequestMapping("/test3")
	public String mav3(SessionStatus ss) {
		ss.setComplete(); // attr1 & attr2 are still showing in /test3, but they won't be shown in test4
		return "test3";
	}
	@RequestMapping("/test4")
	public String mav4() {
		return "test4";
	}
}
