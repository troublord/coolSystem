package com.troublord.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "customer")
public class Customer {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Contact")
	private String contact;
	@Column(name = "Fax")
	private String fax;
	@Column(name = "Number")
	private String number;
	@Column(name = "Address")
	private String address;
	@Column(name = "Ps")
	private String ps;
	
	
	public Customer() {
		
	}
	
	public Customer(int id, String name, String contact, String fax, String number, String address, String ps) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.fax = fax;
		this.number = number;
		this.address = address;
		this.ps = ps;
	}
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + ", fax=" + fax + ", number=" + number
				+ ", address=" + address + ", ps=" + ps + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	
	
	
	
	
}
