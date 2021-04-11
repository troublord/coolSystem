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
@Table(name="shipment_detail")
public class ShipmentDetail {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Shipment_id")
	private Shipment shipment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Product_id")
	private Product product;
	
	@Column(name="Amount")
	private int amount;
	
	@Column(name="Ps")
	private String ps;
	
	public ShipmentDetail() {}

	public ShipmentDetail(int amount, String ps) {
		this.amount = amount;
		this.ps = ps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	@Override
	public String toString() {
		return "ShipmentDetail [id=" + id + ", amount=" + amount + ", ps=" + ps + "]";
	}
	
	
	
	
}
