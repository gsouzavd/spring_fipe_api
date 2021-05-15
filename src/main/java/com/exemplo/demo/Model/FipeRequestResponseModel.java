package com.exemplo.demo.Model;

import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeRequestResponseModel {
	
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("codigo")
	private String codigo;
	
	public FipeRequestResponseModel() {
		super();
	}

	public FipeRequestResponseModel(String nome, int codigo) {
		super();
		this.nome = nome;
		this.codigo = String.valueOf(codigo);
	}
	
	public FipeRequestResponseModel(String nome, String codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
