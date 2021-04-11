package com.troublord.Dao;

import java.util.List;

import com.troublord.Entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer target);

	public void deleteCustomer(int id);

	public Customer getCustomer(int id);
}
