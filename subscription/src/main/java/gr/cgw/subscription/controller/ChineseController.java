package gr.cgw.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gr.cgw.subscription.model.ChineseSubscriber;
import gr.cgw.subscription.service.ChineseSubscriberService;

@Controller
@RequestMapping("/china")
public class ChineseController {

	@Autowired
	private ChineseSubscriberService chineseSubscriberService;

	@RequestMapping("/list")
	public ModelAndView showall() {
		ModelAndView mav = new ModelAndView("showAllChinese", "allChinese",
		chineseSubscriberService.getChineseSubscribers());
		return mav;
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("chinaSubscriber") ChineseSubscriber cs) {
		chineseSubscriberService.saveChineseSubscriber(cs);
		return "redirect:/china/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		ChineseSubscriber cs= new ChineseSubscriber();
		model.addAttribute("chinaSubscriber", cs);
		return "add-china-form";
	}
	
	@GetMapping("/update")
	public String edit(@RequestParam("id") int id, Model model) {
		ChineseSubscriber cs= chineseSubscriberService.getChineseSubscriber(id);
		model.addAttribute("chinaSubscriber", cs);
		return "add-china-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		chineseSubscriberService.disableChineseSubscriber(id);
		return "redirect:/china/list";
	}

}
