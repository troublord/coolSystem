package com.troublord.Dao;

import java.util.List;

import com.troublord.Entity.Customer;
import com.troublord.Entity.Product;
import com.troublord.Entity.ProductDetail;

public interface ProductDAO {

	public List<Product> getProducts();

	public void saveProduct(Product target);

	public void deleteProduct(int id);

	public Product getProduct(int id);

//	public ProductDetail getDetail(int detailId);

	public void saveDetail(ProductDetail target);

	public List<Product> getProductsByCustomer(Customer customer);

	
	
}
