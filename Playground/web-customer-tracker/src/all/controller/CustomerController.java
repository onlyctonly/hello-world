package all.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import all.dao.CustomerDAO;
import all.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	 
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerDAO.getCustomer();
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
