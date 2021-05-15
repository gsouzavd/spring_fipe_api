package com.exemplo.demo.Model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CarModel {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String modelo;
	private String ano;
	private String marca;
	private String CPF;
	private String placa;
	
	// Parameters outside the table
	@Transient
	private String rotationDay;
	
	@Transient
	private boolean rotationActive;
	
	public CarModel() {
		super();
	}
	
	public CarModel(String marca) {
		super();
		this.marca = marca;
	}
	
	public CarModel(String modelo, String marca) {
		super();
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public CarModel(String modelo, String ano, String marca) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
	}
	
	public CarModel(String modelo, String ano, String marca, String cPF, String placa) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		CPF = cPF;
		this.placa = placa;
		this.setRotationDay();
		this.setRotationActive();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getRotationDay() {
		return this.rotationDay;
	}
	
	public void setRotationDay() {
		char last = this.placa.charAt(this.placa.length() - 1);
		if (last == '0' || last == '1') {
			this.rotationDay = "segunda-feira";
		} else if (last == '2' || last == '3') {
			this.rotationDay = "terça-feira";
		} else  if (last == '4' || last == '5') {
			this.rotationDay = "quarta-feira";
		} else  if (last == '6' || last == '7') {
			this.rotationDay = "quinta-feira";
		} else  if (last == '8' || last == '9') {
			this.rotationDay = "sexta-feira";
		} 
	}

	public boolean getRotationActive() {
		return rotationActive;
	}

	public void setRotationActive() {
		char last = this.placa.charAt(this.placa.length() - 1);
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		this.rotationActive = false;
		// Checks if it's necessary to chance the value to true
		switch (day) {
		    case Calendar.MONDAY:
		    	if (last == '0' || last == '1') {
					this.rotationActive = true;
				}
		        break;
		    case Calendar.TUESDAY:
		    	if (last == '2' || last == '3') {
					this.rotationActive = true;
				}
		        break;
		    case Calendar.WEDNESDAY:
		    	if (last == '4' || last == '5') {
					this.rotationActive = true;
				}
		        break;
		    case Calendar.THURSDAY:
		    	if (last == '6' || last == '7') {
					this.rotationActive = true;
				}
		        break;
		    case Calendar.FRIDAY:
		    	if (last == '8' || last == '9') {
					this.rotationActive = true;
				}
		        break;
		    default:
		    	this.rotationActive = false;
		}
	}
	
	
	
}
