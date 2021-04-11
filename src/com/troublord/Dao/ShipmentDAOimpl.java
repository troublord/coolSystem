package com.troublord.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.troublord.Entity.Product;
import com.troublord.Entity.ProductDetail;
import com.troublord.Entity.Receive_detail;
import com.troublord.Entity.Shipment;
import com.troublord.Entity.ShipmentDetail;
import com.troublord.Entity.ShipmentProduct;

@Repository
public class ShipmentDAOimpl implements ShipmentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Map<Integer, ShipmentProduct> productMap = new HashMap<>();
	private Map<Integer, String> customerMap = new HashMap<>();

	
	@Override
	@Transactional
	public List<Shipment> getSheet() {
		Session session = sessionFactory.getCurrentSession();
		Query<Shipment> query = session.createQuery("from Shipment", Shipment.class );
		List<Shipment> sheet = query.getResultList();
		for(Shipment s : sheet) {
			for(ShipmentDetail sd : s.getShipment_detail()) {
//				productMap.put(sd.getId(), sd.getProduct().getName());String productName, int amount, String ps
				String productName = sd.getProduct().getName();
				int price = sd.getProduct().getPrice();
				ShipmentProduct productSimplified = new ShipmentProduct(productName,price);
				productMap.put(sd.getId(), productSimplified);
			}
			customerMap.put(s.getId(), s.getCustomer().getName());
		}
		
		return sheet;
	}
	@Override
	@Transactional
	public void saveShipment(Shipment target) {
		Session session = sessionFactory.getCurrentSession();//need to iniitiate detail first(save detail but don't add )
		List<ShipmentDetail> revise = target.getShipment_detail();

		for (ShipmentDetail sd : revise) {
			Product temp = sd.getProduct();
			if (temp != null && temp.getId() != 40) {
				ProductDetail updateDetail = sd.getProduct().getProductDetail();
				int finale = updateDetail.getMaterial() - sd.getAmount();
				updateDetail.setMaterial(finale);
				session.saveOrUpdate(updateDetail);
			} else {
				System.out.println("no product yet");
			}
		}
		session.saveOrUpdate(target);
		
		
	}
	@Override
	public Map<Integer, ShipmentProduct> getProductMap() {
		// TODO Auto-generated method stub
		return this.productMap;
	}

	@Override
	public Map<Integer, String> getCustomerMap() {
		// TODO Auto-generated method stub
		return this.customerMap;
	}
	@Override
	@Transactional
	public void saveDetail(ShipmentDetail sd) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sd);
		
	}

	
	
	
}
