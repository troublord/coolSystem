package com.troublord.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "material")
	private int material;
	@Column(name = "finished")
	private int finished;
	@Column(name = "placement")
	private String placement;
	
	public ProductDetail() {
		
	}

	public ProductDetail(int material, int finished, String placement) {
		this.material = material;
		this.finished = finished;
		this.placement = placement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	public int getFinished() {
		return finished;
	}

	public void setFinished(int finished) {
		this.finished = finished;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", material=" + material + ", finished=" + finished + ", placement="
				+ placement + "]";
	}
	
	
	
	
}
