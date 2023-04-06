package com.tigersystemseller.rest.product;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tigersystemseller.model.Product;

public class ProductFormRequest {
	private Long id;
	private String description;
	private String name;
	private BigDecimal price;
	private String sku;
	@JsonFormat(pattern ="yyyy-MM-dd")
	private LocalDate register;

	public ProductFormRequest(Long id, String description, String name, BigDecimal price, String sku,
			LocalDate register) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
		this.sku = sku;		
		this.register = register;
	}

	public Product toModel() {
		return new Product(id, name, description, price, sku);
	}

	public static ProductFormRequest fromModel(Product product) {
		return new ProductFormRequest(product.getId(), product.getDescription(), product.getName(), product.getPrice(),
				product.getSku(), product.getDateRegister());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRegister() {
		return register;
	}

	public void setRegister(LocalDate register) {
		this.register = register;
	}

	@Override
	public String toString() {
		return "ProductFormRequest [id=" + id + ", description=" + description + ", name=" + name + ", price=" + price
				+ ", sku=" + sku + "]";
	}
}
