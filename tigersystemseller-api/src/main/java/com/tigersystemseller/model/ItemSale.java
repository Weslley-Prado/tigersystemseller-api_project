package com.tigersystemseller.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_sale")
public class ItemSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	//Mapeamento de muito para um
	@ManyToOne
	@JoinColumn(name = "id_sale")
    private Sale sale;
	
	@ManyToOne
	@JsonFormat( pattern = "dd/MM/yyyy")
	@JoinColumn(name = "id_product")
    private Product product;
	
	@Column
    private Integer quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ItemSale [id=" + id + ", sale=" + sale + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
}
