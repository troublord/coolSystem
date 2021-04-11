package com.troublord.Controller;


import java.util.ArrayList;
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
import com.troublord.Dao.ShipmentDAO;
import com.troublord.Entity.Customer;
import com.troublord.Entity.Product;
import com.troublord.Entity.Receive;
import com.troublord.Entity.Receive_detail;
import com.troublord.Entity.Shipment;
import com.troublord.Entity.ShipmentDetail;
import com.troublord.Entity.ShipmentProduct;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {
	
	@Autowired
	private ShipmentDAO shipmentDAO;
	@Autowired 
	private CustomerDAO customerDAO;
	@Autowired 
	private ProductDAO productDAO;
	
	@RequestMapping("/list_shipments")
	public String list_shipments(Model model) {
		List<Shipment> sheets = shipmentDAO.getSheet();//這一串有detail沒有customer(透過product)，detail沒有receive(不需要),product()
		model.addAttribute("shipments",sheets);//這邊使用map去插入
		Map<Integer, ShipmentProduct> productMap = shipmentDAO.getProductMap();//key是receive_detail_id value是product_name
		model.addAttribute("productMap",productMap);
		Map<Integer, String> customerMap = shipmentDAO.getCustomerMap();
		model.addAttribute("customerMap", customerMap);
		
		return "shipment/list_shipment";
	}
	@GetMapping("/showShipmentForm")
	public String showShipmentForm(Model model) {
		Shipment target = new Shipment();
		List<Customer> customers = customerDAO.getCustomers();
		List<Product> products = productDAO.getProducts();
		model.addAttribute("customers", customers);
		model.addAttribute("products", products);
		model.addAttribute("shipment", target);
		
		return "shipment/shipment_form";
	}
	@PostMapping("/saveShipment")
	public String saveShipment(Model model , @ModelAttribute("shipment") Shipment target , 
			@RequestParam("customer_id") int Id, @RequestParam("detailCount") int count	) {
		List<ShipmentDetail> emptyDetail = new ArrayList<>();
		target.setTotal(0);
		Customer customer = customerDAO.getCustomer(Id);
		List<Product> products =  productDAO.getProductsByCustomer(customer);
		target.setCustomer(customer);
		for(int i = 0;i<count;i++) {
			ShipmentDetail newone = new ShipmentDetail(0,"暫無");
			newone.setShipment(target); 
			Product tempProduct = productDAO.getProduct(40);
			newone.setProduct(tempProduct);
			emptyDetail.add(newone);
			
		}
		target.setShipment_detail(emptyDetail);
		shipmentDAO.saveShipment(target);

		
		
		model.addAttribute("customer", customer.getName());
		model.addAttribute("shipment", target); // this target do not have id attached
		model.addAttribute("products", products);

		return  "/shipment/shipment_detail";
	}
	@PostMapping("/saveDetail")
	public String saveDetail(Model model, @ModelAttribute("shipment") Shipment target,
							@RequestParam("targetProducts") List<Integer> targetProducts,
							@RequestParam("customer_id") int customer_id) {
		List<ShipmentDetail> details = target.getShipment_detail();
		Customer customer = customerDAO.getCustomer(customer_id);
		System.out.println(target.getId());
		int total = 0;
		for(int i =0;i<targetProducts.size();i++) {
			Product temp = productDAO.getProduct(targetProducts.get(i));
			int amount = details.get(i).getAmount();
			details.get(i).setProduct(temp);
			details.get(i).setShipment(target);
			total = total + amount;
		}
		target.setTotal(total);  //這邊的total應該是amount * price 要改一夏
		target.setCustomer(customer);
		shipmentDAO.saveShipment(target);
		
		
		return "redirect:/shipment/list_shipments";
	}
	
}
