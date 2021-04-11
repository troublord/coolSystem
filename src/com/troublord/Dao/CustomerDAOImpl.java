package com.troublord.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.troublord.Entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer" , Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer target) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(target);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
	 	Customer target = session.get(Customer.class, id);
		return target;
		
		
	}

}
