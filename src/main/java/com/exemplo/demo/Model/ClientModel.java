package com.exemplo.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ClientModel {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String CPF;
    private String birthDate;
    
    public ClientModel() {
		super();
	}
    
    public ClientModel(String cPF) {
		super();
		this.CPF = cPF;
	}
    
	public ClientModel(String email, String cPF) {
		super();
		this.email = email;
		CPF = cPF;
	}

	public ClientModel(String name, String email, String cPF, String birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.CPF = cPF;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	} 
    
}