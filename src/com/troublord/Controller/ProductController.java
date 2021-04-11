package com.troublord.Controller;

import java.util.List;

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
import com.troublord.Entity.Customer;
import com.troublord.Entity.Product;
import com.troublord.Entity.ProductDetail;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	
	@GetMapping("/list_products")
	public String list_products(Model model) {
		List<Product> products = productDAO.getProducts();
		model.addAttribute("products", products);
		List<Customer> customers = customerDAO.getCustomers();
		model.addAttribute("customers",customers);
		
		return "product/list_products";
	}
	
	@RequestMapping("/showProductForm")
	public String showProductForm(Model model) {
		Product target = new Product();
		List<Customer> customers = customerDAO.getCustomers();
		
		model.addAttribute("customers" , customers);
		model.addAttribute("product" , target);
		
		return "product/product_form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(Model model , @ModelAttribute("product") Product target , 
								@RequestParam("customer_id") int Id	) {
		ProductDetail oldDetail;
		Product oldOne = productDAO.getProduct(target.getId());
		if(oldOne==null) {
			oldDetail = new ProductDetail(0,0,"¥¼¶ñ¼g");
			System.out.println("================alert line====================");
		}else {
			oldDetail = oldOne.getProductDetail();
			System.out.println("==============="+oldDetail+"====================");
		}

		target.setProductDetail(oldDetail);
		Customer customer = customerDAO.getCustomer(Id);
		target.setCustomer(customer);
		productDAO.saveProduct(target);//do it after product detail being saved
		
		return  "redirect:/product/list_products";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id) {

		
		productDAO.deleteProduct(id);
		return "redirect:/product/list_products";
	}
	@GetMapping("/showUpdateProduct")
	public String showUpdateProduct(@RequestParam("productId") int id ,  Model model ) {
		List<Customer> customers = customerDAO.getCustomers();
		Product target = productDAO.getProduct(id);
		model.addAttribute("product", target);
		model.addAttribute("customers" , customers);
		
		return "product/product_form";
	}
	
	@PostMapping("/updateDetail")
	public String updateDetail(Model model, @ModelAttribute("detail") ProductDetail target, 
			@RequestParam("detailId") int detailId) {
		System.out.println(target);
		target.setId(detailId);
		productDAO.saveDetail(target);
		System.out.println(target);
		
		return "redirect:/product/list_products";
	}
	
	
	
}
