package com.tigersystemseller.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name", length = 100)
	private String name;
	@Column(name="description", length = 255)
	private String description;
	@Column(name="price", precision = 16, scale = 2)
	private BigDecimal price;
	@Column
	private String sku;	
	@Column(name = "date_register")
	private LocalDate dateRegister;
	
	public Product() {
		super();
	}
	public Product(String name, String description, BigDecimal price, String sku) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.sku = sku;
	}
	
	public Product(Long id, String name, String description, BigDecimal price, String sku) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.sku = sku;
	}
	@PrePersist
	public void prePersist() {
		setDateRegister(LocalDate.now());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public LocalDate getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(LocalDate dateRegister) {
		this.dateRegister = dateRegister;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", sku="
				+ sku + "]";
	}

}
