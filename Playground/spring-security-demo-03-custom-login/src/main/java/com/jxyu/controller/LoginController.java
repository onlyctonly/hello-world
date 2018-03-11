package com.jxyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/myloginpage")
	public String myloginpage() {
		return "plain-login";
	}
}
