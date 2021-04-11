package com.troublord.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.troublord.Dao.CustomerDAO;
import com.troublord.Dao.ProductDAO;
import com.troublord.Dao.ReceiveDAO;
import com.troublord.Entity.Customer;
import com.troublord.Entity.Product;
import com.troublord.Entity.Receive;
import com.troublord.Entity.Receive_detail;

@Controller
@RequestMapping("/receive")
public class ReceiveController {
	
	@Autowired
	private ReceiveDAO receiveDAO ;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/list_sheet")
	public String cargosheets(Model model) {
		List<Receive> sheets = receiveDAO.getSheet();//這一串有detail沒有customer(透過product)，detail沒有receive(不需要),product()
		model.addAttribute("receives",sheets);//這邊使用map去插入
		Map<Integer, String> productMap = receiveDAO.getProductMap();//key是receive_detail_id value是product_name
		model.addAttribute("productMap",productMap);
		Map<Integer, String> customerMap = receiveDAO.getCustomerMap();
		model.addAttribute("customerMap", customerMap);
		return "receive/list_sheet";
	}
	
	@GetMapping("/showReceiveForm")
	public String showReceiveForm(Model model) {
		Receive target = new Receive();
		List<Customer> customers = customerDAO.getCustomers();
		List<Product> products = productDAO.getProducts();
		model.addAttribute("customers", customers);
		model.addAttribute("products", products);
		model.addAttribute("receive", target);
		return "receive/receive_form";
	}
	
	@PostMapping("/saveReceive")
	public String saveReceive(Model model , @ModelAttribute("receive") Receive target , 
			@RequestParam("customer_id") int Id, @RequestParam("detailCount") int count	) {
		List<Receive_detail> emptyDetail = new ArrayList<>();
		target.setTotal(0);
		Customer customer = customerDAO.getCustomer(Id);
		List<Product> products =  productDAO.getProductsByCustomer(customer);
		target.setCustomer(customer);
		for(int i = 0;i<count;i++) {
			Receive_detail newone = new Receive_detail(0,"暫無");
			newone.setReceive(target);
			Product tempProduct = productDAO.getProduct(40);
			newone.setProduct(tempProduct); 
			emptyDetail.add(newone);
		}
		target.setReceive_detail(emptyDetail); 
		receiveDAO.saveReceive(target);
		
		
		model.addAttribute("customer", customer.getName());
		model.addAttribute("receive", target);
		model.addAttribute("products", products);
		System.out.println(target.getId());
		return  "/receive/receive_detail";
	}
	
	@PostMapping("/saveDetail")
	public String saveDetail(Model model, @ModelAttribute("receive") Receive target,
							@RequestParam("targetProducts") List<Integer> targetProducts,
							@RequestParam("customer_id") int customer_id) {
		List<Receive_detail> details = target.getReceive_detail();
		Customer customer = customerDAO.getCustomer(customer_id);
		int total = 0;
		for(int i =0;i<targetProducts.size();i++) {
			Product temp = productDAO.getProduct(targetProducts.get(i));
			int amount = details.get(i).getAmount();
			details.get(i).setProduct(temp);
			details.get(i).setReceive(target);
			total = total + amount;
		}
		target.setTotal(total);
		target.setCustomer(customer);

		receiveDAO.saveReceive(target);
		
		return "redirect:/receive/list_sheet";
	}
	
	@GetMapping("/deleteReceive")
	public String deleteReceive(@RequestParam("receiveId") int id) {
		receiveDAO.deleteReceive(id);
	
		return "redirect:/receive/list_sheet";
	}
	@GetMapping("/showUpdateReceive")
	public String showUpdateReceive(Model model , @RequestParam("receiveId") int id) {
		Receive target = receiveDAO.getReceive(id);
		List<Customer> customers = customerDAO.getCustomers();
		model.addAttribute("customers", customers);
		model.addAttribute("receive", target);
		return "receive/update_form";
	}
	
	@PostMapping("/updateReceive") 
	public String updateReceive(Model model,
								@ModelAttribute("receive") Receive target) {

		receiveDAO.saveUpdate(target);

		return "redirect:/receive/list_sheet";
	}
	@GetMapping("/deleteDetail")
	public String deleteDetail(@RequestParam("detailId") int id) {
		receiveDAO.deleteDetail(id);
		return "redirect:/receive/list_sheet";
	}
	@GetMapping("/updateDetail")
	public String updateDetail(@RequestParam("detailId") int id, Model model) {
		Receive_detail detail = receiveDAO.getReceiveDetail(id);
		
		Customer customer = receiveDAO.getCustomerbyProduct(detail);
		List<Product> products =  productDAO.getProductsByCustomer(customer);
		model.addAttribute("detail", detail);
		model.addAttribute("products", products);
		return "receive/detail_form";
	}
	@PostMapping("/updateDetailForm")
	public String updateDetailForm(@ModelAttribute("detail") Receive_detail detail,
			@RequestParam("targetProduct") int targetProduct) {
		Product product = productDAO.getProduct(targetProduct);
		detail.setProduct(product);
		receiveDAO.updateDetail(detail);
		return "redirect:/receive/list_sheet";
	}
	
}
