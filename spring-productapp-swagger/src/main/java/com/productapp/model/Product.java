package com.productapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
    @Column(name = "name" , length=20)
	private String productName;
	@Id
	@GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1) // to create autoincrement ids
	private Integer productId;
	private double price;
	@Column(length=10)
	private String brand;
	
	private String category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String productName, Double price, String brand, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + ", price=" + price + ", brand="
				+ brand + ", category=" + category + "]";
	}
	
	
	
	
	
	
}
