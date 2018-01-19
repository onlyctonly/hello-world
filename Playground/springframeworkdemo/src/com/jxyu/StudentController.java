package com.jxyu;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@InitBinder
	public void initBinder(WebDataBinder wb) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		wb.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/showform")
	public String showform(Model model) {
		Student sd = new Student();
		model.addAttribute("sd", sd);
		return "student-form";
	}
	@RequestMapping("/processform")
	public String processform(@Valid @ModelAttribute("sd") Student sd, BindingResult br) {
		System.out.println(br);
		if(br.hasErrors()) {
			return "student-form";
		} else {
		
		return "student-confirmation";
		}
	}
}
