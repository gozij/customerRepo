package com.tts.MyNearlyAwesome.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(value= "/")
	public String index (Customer customer) {
		return "customer/index";

}
	private Customer customer;
	@PostMapping(value= "/")
	public String addNewCustomer(Customer customer, Model model) {
		customerRepository.save(new Customer(customer.getFirstName(), 
	        customer.getLastName(), customer.getUserName(), customer.getSignedUp()));
		model.addAttribute("firstName", customer.getFirstName());
		model.addAttribute("lastName", customer.getLastName());
		model.addAttribute("userName", customer.getUserName());
		return "customer/result";
	}
	
    @GetMapping("/style")
    public String style() {
    	return "add-css-js-customer";
    }
}
