package com.jxyu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
	
	@Autowired
	private JokeServiceImpl jokeServiceImpl;
	
	@RequestMapping("/")
	public String getJoke(Model model) {
		model.addAttribute("joke", jokeServiceImpl.getJoke());
		return "joke";
	}
}
