package com.tigersystemseller.model;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonFormat( pattern = "dd/MM/yyyy")
	@JoinColumn(name = "id_client")
	private Client client;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment")
	private Payment payment;
	
	@OneToMany(mappedBy = "sale")
    private List<ItemSale> items;
	@Column
    private BigDecimal total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<ItemSale> getItems() {
		return items;
	}
	public void setItems(List<ItemSale> items) {
		this.items = items;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", client=" + client + ", payment=" + payment + ", items=" + items + ", total="
				+ total + "]";
	}	
}
