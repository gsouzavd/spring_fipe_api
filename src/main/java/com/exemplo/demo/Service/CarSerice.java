package com.exemplo.demo.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.exemplo.demo.Model.CarModel;
import com.exemplo.demo.Model.FipeCarModel;
import com.exemplo.demo.Model.FipeRequestResponseModel;

@Component
public interface CarSerice {
	

	public List<FipeRequestResponseModel> getBrands();
	
	public List<FipeRequestResponseModel> getModels(CarModel carModel);

	public List<FipeRequestResponseModel> getYears(CarModel carModel);
	
	public FipeCarModel getCarFromFipe(CarModel carModel);

	public List<CarModel> getCarsFromClient(String CPF);
	
	public CarModel addCarToClient(CarModel carModel) throws IllegalArgumentException;
}
