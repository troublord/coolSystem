package com.troublord.Dao;

import java.util.List;
import java.util.Map;

import com.troublord.Entity.Customer;
import com.troublord.Entity.Receive;
import com.troublord.Entity.Receive_detail;

public interface ReceiveDAO {

	public List<Receive> getSheet();

	public Map<Integer, String> getProductMap();

	public Map<Integer, String> getCustomerMap();

	public void saveReceive(Receive target);

	public void saveDetail(Receive_detail rd);

	public void deleteReceive(int id);

	public Receive getReceive(int id);

	public void saveUpdate(Receive target);

	public void deleteDetail(int id);

	public Receive_detail getReceiveDetail(int id);

	public void updateDetail(Receive_detail detail);

	public Customer getCustomerbyProduct(Receive_detail detail);

//	Map<Integer, String> setProduct(Map<Integer, String> productMap, List<Receive> sheets);

	
}
