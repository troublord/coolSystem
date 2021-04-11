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
import javax.persistence.Table;

@Entity
@Table(name="shipment")
public class Shipment {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Date")
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Customer_id")
	private Customer customer;
	@Column(name="Total")
	private int total;

	@OneToMany(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER, mappedBy = "shipment")
	private List<ShipmentDetail> shipment_detail;
	
	public Shipment() {}

	public Shipment(String name, Date date, Customer customer) {
		this.name = name;
		this.date = date;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
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


	public List<ShipmentDetail> getShipment_detail() {
		return shipment_detail;
	}

	public void setShipment_detail(List<ShipmentDetail> shipment_detail) {
		this.shipment_detail = shipment_detail;
	}

	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Shipment [id=" + id + ", name=" + name + ", date=" + date + ","
				 + ", shipment_detail=" + shipment_detail + "]";
	}
	
	
	
}
