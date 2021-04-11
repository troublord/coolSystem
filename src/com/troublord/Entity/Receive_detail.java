package com.troublord.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receive_detail")
public class Receive_detail {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Receive_id")
	private Receive receive;

	@Column(name = "Amount")
	private int amount;

	@Column(name = "Ps")
	private String ps;

	@ManyToOne(fetch = FetchType.LAZY)//©|«Ý°Q½×
	@JoinColumn(name = "Product_id")
	private Product product;

	public Receive_detail() {

	}

	public Receive_detail(int amount, String ps) {

		this.amount = amount;
		this.ps = ps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Receive getReceive() {
		return receive;
	}

	public void setReceive(Receive receive) {
		this.receive = receive;
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
		return "Receive_detail [id=" + id + ", amount=" + amount + ", ps=" + ps + "]";
	}

}
