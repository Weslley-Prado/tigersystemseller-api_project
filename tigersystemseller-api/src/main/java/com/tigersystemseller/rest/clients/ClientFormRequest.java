package com.tigersystemseller.rest.clients;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tigersystemseller.model.Client;

public class ClientFormRequest {
	
	private Long id;
	private String name;
	private String cpf;
	@JsonFormat( pattern = "dd/MM/yyyy")
	private LocalDate birthDate;	
	private String address;
	private String email;
	private String phoneNumber;
	@JsonFormat( pattern = "dd/MM/yyyy")
	private LocalDate dateRegister;
	
	
	
	public ClientFormRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ClientFormRequest(Long id, String name, String cpf, LocalDate birthDate, String address, String email,
			String phoneNumber, LocalDate dateRegister) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateRegister = dateRegister;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(LocalDate dateRegister) {
		this.dateRegister = dateRegister;
	}
	
	public Client toModel() {
		return new Client(id, name, birthDate, cpf, address, phoneNumber, email, dateRegister);
	}
	
	public static ClientFormRequest fromModel(Client client) {
		return new ClientFormRequest(
				client.getId(), 
				client.getName(), 
				client.getCpf(), 
				client.getBirthDate(), 				
				client.getAddress(), 
				client.getPhoneNumber(),
				client.getEmail(),
				client.getDateRegister());
	}
	
}
