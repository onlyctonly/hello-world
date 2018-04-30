package gr.cgw.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.cgw.subscription.model.GreekSubscriber;
import gr.cgw.subscription.service.GreekSubscriberService;

@Controller
@RequestMapping("/greek")
public class GreekController {
	
	@Autowired
	private GreekSubscriberService greekSubscriberService;
	
	@GetMapping("/list")
	public String listGreekSubscribers(Model model) {
		List<GreekSubscriber> gs = greekSubscriberService.getGreekSubscribers();
		model.addAttribute("greeksubscribers", gs);
		return "list-subscribers";
	}
	
	@GetMapping("/add")
	public String addGreekSubscribers(Model model) {
		GreekSubscriber gs = new GreekSubscriber();
		model.addAttribute("greekSubscriber", gs);
		return "add-greek-form";
	}
	@PostMapping("/save")
	public String saveGreekSubscribers(@ModelAttribute("greekSubscriber") GreekSubscriber gs) {
		greekSubscriberService.saveGreekSubscriber(gs);
		return "redirect:/greek/list";
	}
	
	@GetMapping("/update")
	public String updateGreekSubscriber(@RequestParam("id") int id, Model model) {
		GreekSubscriber gs = greekSubscriberService.getGreekSubscriber(id);
		model.addAttribute("greekSubscriber", gs);
		return "add-greek-form";
	}
	
	@GetMapping("/delete")
	public String deleteGreekSubscriber(@RequestParam("id") int id) {
		greekSubscriberService.disableGreekSubscriber(id);
		return "redirect:/greek/list";
	}
	
}
