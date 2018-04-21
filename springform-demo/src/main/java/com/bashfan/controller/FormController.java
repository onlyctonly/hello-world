package com.bashfan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bashfan.model.Organization;
import com.bashfan.service.OrganizationTurnover;

@Controller
public class FormController {
	
	@Autowired
	private OrganizationTurnover organizationTurnover;
	
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
	
	@ModelAttribute
	public void orgturnover(Model model) {
		Map<String, Object> map = model.asMap();
		map.put("tlist", organizationTurnover.organizationTurnover());
		map.put("fielddata", organizationTurnover.fields());
	}
	
	
}
