package com.troublord.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "receive")
public class Receive {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "Date")
	private Date date;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_id")
	private Customer customer;
	
	@Column(name = "Total")
	private int total;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER, mappedBy = "receive")
	private List<Receive_detail> receive_detail;
	
	public Receive() {}

	public Receive(Date date, Customer customer , String Name) {
		this.date = date;
		this.customer = customer;
		this.name = name;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public List<Receive_detail> getReceive_detail() {
		return receive_detail;
	}

	public void setReceive_detail(List<Receive_detail> receive_detail) {
		this.receive_detail = receive_detail;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Receive [date=" + date + ", name=" + name + ", total=" + total + "]";
	}


	
	
	
	
	
	
}
