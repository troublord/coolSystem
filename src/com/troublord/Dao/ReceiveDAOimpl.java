package com.troublord.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.troublord.Entity.Customer;
import com.troublord.Entity.Product;
import com.troublord.Entity.ProductDetail;
import com.troublord.Entity.Receive;
import com.troublord.Entity.Receive_detail;

@Repository
public class ReceiveDAOimpl implements ReceiveDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Map<Integer, String> productMap = new HashMap<>();
	private Map<Integer, String> customerMap = new HashMap<>();

	@Override
	@Transactional
	public List<Receive> getSheet() {

		Session session = sessionFactory.getCurrentSession();
		Query<Receive> query = session.createQuery("from Receive", Receive.class);
		List<Receive> sheet = query.getResultList();
			for (Receive r : sheet) {
				for (Receive_detail rd : r.getReceive_detail()) {
					productMap.put(rd.getId(), rd.getProduct().getName());
				}
				customerMap.put(r.getId(), r.getCustomer().getName());
			}	

		return sheet;
	}

	@Override
	@Transactional
	public void saveReceive(Receive target) {
		Session session = sessionFactory.getCurrentSession();
		List<Receive_detail> revise = target.getReceive_detail();

		for (Receive_detail rd : revise) {
			Product temp = rd.getProduct();
			if (temp != null && temp.getId() != 40) {
				Product update = rd.getProduct();
				ProductDetail updateDetail = update.getProductDetail();
				int finale = updateDetail.getMaterial() + rd.getAmount();
				updateDetail.setMaterial(finale);
				session.saveOrUpdate(updateDetail);
			} else {
				System.out.println("no product yet");
			}
		}
		session.saveOrUpdate(target);

	}

	@Override
	public Map<Integer, String> getProductMap() {
		return productMap;
	}

	@Override
	public Map<Integer, String> getCustomerMap() {

		return customerMap;
	}

	@Override
	@Transactional
	public void saveDetail(Receive_detail rd) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(rd);

	}

	@Override
	@Transactional
	public void deleteReceive(int id) {
		Session session = sessionFactory.getCurrentSession();
		Receive target = session.get(Receive.class, id);
		List<Receive_detail> revise = target.getReceive_detail();
		for (Receive_detail rd : revise) {
			Product update = rd.getProduct();
			ProductDetail updateDetail = update.getProductDetail();
			int finale = updateDetail.getMaterial() - rd.getAmount();
			updateDetail.setMaterial(finale);
			session.saveOrUpdate(updateDetail);
		}
		session.delete(target);

	}

	@Override
	@Transactional
	public Receive getReceive(int id) {
		Session session = sessionFactory.getCurrentSession();
		Receive target = session.get(Receive.class, id);
		return target;
	}

	@Override
	@Transactional
	public void saveUpdate(Receive target) {
		Session session = sessionFactory.getCurrentSession();
		Receive temp = session.get(Receive.class, target.getId());
		temp.setDate(target.getDate());
		temp.setName(target.getName());
		session.save(temp);
	}

	@Override 
	@Transactional
	public void deleteDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		Receive_detail target = session.get(Receive_detail.class, id);
		Product revise = target.getProduct();
		ProductDetail reviseDetail = revise.getProductDetail();
		int material = reviseDetail.getMaterial() - target.getAmount();
		reviseDetail.setMaterial(material);
		Receive affected = target.getReceive();
		int total = affected.getTotal() - target.getAmount();
		affected.setTotal(total);
		List<Receive_detail> targetList = affected.getReceive_detail();
		targetList.remove(target);
		affected.setReceive_detail(targetList);
		session.delete(target);
		session.saveOrUpdate(reviseDetail);
		
	}

	@Override
	@Transactional
	public Receive_detail getReceiveDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		Receive_detail target = session.get(Receive_detail.class, id);
		return target;
	}

	@Override
	@Transactional
	public void updateDetail(Receive_detail detail) {
		Session session = sessionFactory.getCurrentSession();
		
		Receive_detail target = session.get(Receive_detail.class, detail.getId());
		Product revise = target.getProduct();
		ProductDetail reviseDetail = revise.getProductDetail();
		int material = reviseDetail.getMaterial()-target.getAmount()+detail.getAmount();
		target.setAmount(detail.getAmount());
		target.setProduct(detail.getProduct());
		target.setPs(detail.getPs());
		reviseDetail.setMaterial(material);

		session.saveOrUpdate(target);
	    Receive R = session.get(Receive.class, target.getReceive().getId());
	    int total=0;
	    for(Receive_detail rd :R.getReceive_detail()) {
	    	total = total + rd.getAmount();
	    }
	    R.setTotal(total);
		session.saveOrUpdate(R);
		session.saveOrUpdate(reviseDetail);
	}

	@Override
	@Transactional
	public Customer getCustomerbyProduct(Receive_detail detail) {
		Session session = sessionFactory.getCurrentSession();
		Receive_detail access = session.get(Receive_detail.class, detail.getId());
		Customer target =  access.getReceive().getCustomer();
		return target;
	}



}
