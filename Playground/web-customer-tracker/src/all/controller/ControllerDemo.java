package all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ControllerDemo {
	@RequestMapping("/test")
	public String test(Model model) {
		return "test";
	}
}
