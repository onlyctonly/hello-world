package com.bashfan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyAppController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello-world";
	}
}
