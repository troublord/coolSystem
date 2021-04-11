package com.troublord.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.troublord.Entity.Customer;
import com.troublord.Entity.Product;
import com.troublord.Entity.ProductDetail;

@Repository
public class ProductDAOimpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product" , Product.class);
		List<Product> products = query.getResultList();

		
		return products;
	}


	@Override
	@Transactional
	public void saveProduct(Product target) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(target);
	}


	@Override
	@Transactional
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product target = session.get(Product.class, id);
//		Query query = session.createQuery("delete from Product where id=:productId");
//		query.setParameter("productId", id);
//		query.executeUpdate();
		session.delete(target);
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product target = session.get(Product.class, id);
		return target;
	}


	@Override
	@Transactional
	public void saveDetail(ProductDetail target) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(target);
		
	}


	@Override
	@Transactional
	public List<Product> getProductsByCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where customer_id="+customer.getId());
//		query.setParameter("id", customer.getId());
		List<Product> list = query.list();
		
		return list;
	}


//	@Override
//	public ProductDetail getDetail(int detailId) {
//		Session session = sessionFactory.getCurrentSession();
//		ProductDetail target = session.get(ProductDetail.class, detailId);
//		return target;
//	}






}
