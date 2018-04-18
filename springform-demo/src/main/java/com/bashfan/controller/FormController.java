package com.bashfan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bashfan.model.Organization;

@Controller
public class FormController {
	@RequestMapping("/form")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("form", "org", new Organization());
		return mav;
	}
	
	@RequestMapping(value="/showform", method=RequestMethod.POST)
	public String showform(@ModelAttribute Organization org, Model model) {
		model.addAttribute("org", org);
		return "showform";
	}
}
