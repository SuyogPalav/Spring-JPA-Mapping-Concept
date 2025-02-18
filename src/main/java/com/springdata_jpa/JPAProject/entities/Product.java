package com.springdata_jpa.JPAProject.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_product")
public class Product {

	@Id
	private String pId;
	private String productName;

	@ManyToMany(mappedBy = "product")
	private List<Category> category = new ArrayList<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String pId, String productName, List<Category> category) {
		super();
		this.pId = pId;
		this.productName = productName;
		this.category = category;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product pId=" + pId + ", productName=" + productName;
	}

}
