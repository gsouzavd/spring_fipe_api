package com.exemplo.demo.Model;

import java.util.List;

public class FipeModelosResponseModel {

	private List<FipeRequestResponseModel> modelos;

	public FipeModelosResponseModel() {
		super();
	}
	
	public FipeModelosResponseModel(List<FipeRequestResponseModel> modelos) {
		super();
		this.modelos = modelos;
	}

	public List<FipeRequestResponseModel> getModelos() {
		return modelos;
	}

	public void setModelos(List<FipeRequestResponseModel> modelos) {
		this.modelos = modelos;
	}
	
	
}
