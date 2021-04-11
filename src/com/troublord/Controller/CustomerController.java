package com.troublord.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.troublord.Dao.CustomerDAO;
import com.troublord.Entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/home")
	public String testSystem(Model theModel) {
		return "customer/secondtest";
	}
	@GetMapping("/list_customers")
	public String customers(Model model) {
		
		List<Customer> customers = customerDAO.getCustomers();
		model.addAttribute("customers",customers);
		
		return "customer/list_customers";
	}
	
	@GetMapping("/showCustomerForm")
	public String addCustomer(Model model) {
		
		Customer cus = new Customer();
		model.addAttribute("customer" , cus);
		
		return "customer/customer_form";
	}
	
	@RequestMapping(value = "/saveCustomer" , method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer target) {

		customerDAO.saveCustomer(target);
		return "redirect:/customer/list_customers";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(Model model , @RequestParam("customerId") int Id) {
		customerDAO.deleteCustomer(Id) ;
		
		return "redirect:/customer/list_customers";
	}
	
	@GetMapping("/showUpdateCustomer")
	public String showUpdateCustomerForm(Model model , @RequestParam("customerId") int Id) {
		
		Customer target = customerDAO.getCustomer(Id);
	    model.addAttribute("customer" , target);
		
		return "customer/customer_form";
	}

	
}
