package com.jxyu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @RequestMapping("/form")
    public String form(HttpServletRequest request, Model model) {
    		String s = request.getParameter("myname");
    		s = s + " Yo!";
    		model.addAttribute("r", s);
        return "GetForm";
    }

//    @RequestMapping("/showparam")
//    public String showparam(HttpServlet) {
//        return "GetForm";
//    }
}
