package com.exemplo.demo.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.exemplo.demo.Model.CarModel;
import com.exemplo.demo.Model.FipeCarModel;
import com.exemplo.demo.Model.FipeModelosResponseModel;
import com.exemplo.demo.Model.FipeRequestResponseModel;

@Component
@FeignClient(url= "https://parallelum.com.br/fipe/api/v1/carros/" , name = "fipe")
public interface FipeService {

	@GetMapping("marcas")
	public List<FipeRequestResponseModel> getBrands();
	
	@GetMapping("marcas/{marca}/modelos")
	public FipeModelosResponseModel getModels(@PathVariable("marca") String marca);
	
	@GetMapping("marcas/{marca}/modelos/{modelos}/anos")
	public List<FipeRequestResponseModel> getModelYears(@PathVariable("marca") String marca,
											@PathVariable("modelos") String modelos);
	
	@GetMapping("marcas/{marca}/modelos/{modelos}/anos/{anos}")
	public FipeCarModel getCarInformation(@PathVariable("marca") String marca,
											@PathVariable("modelos") String modelos,
											@PathVariable("anos") String anos);
	
}
