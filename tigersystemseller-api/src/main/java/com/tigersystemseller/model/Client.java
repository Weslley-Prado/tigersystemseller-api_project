package com.tigersystemseller.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column (name = "birth_date" )
	private LocalDate birthDate;
	private String cpf;
	private String address;
	@Column (name = "phone_number")
	private String phoneNumber;
	private String email;
	@Column (name = "date_register")
	private LocalDate dateRegister;
	
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(String name, LocalDate birthDate, String cpf, String address, String phoneNumber, String email,
			LocalDate dateRegister) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateRegister = dateRegister;
	}

	public Client(Long id, String name, LocalDate birthDate, String cpf, String address, String phoneNumber,
			String email, LocalDate dateRegister) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateRegister = dateRegister;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(LocalDate dateRegister) {
		this.dateRegister = dateRegister;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", cpf=" + cpf + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", dateRegister=" + dateRegister
				+ "]";
	}

}
