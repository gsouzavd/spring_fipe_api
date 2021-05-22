package com.exemplo.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import com.exemplo.demo.Model.CarModel;
import com.exemplo.demo.Model.FipeCarModel;
import com.exemplo.demo.Model.FipeModelosResponseModel;
import com.exemplo.demo.Model.FipeRequestResponseModel;
import com.exemplo.demo.Repository.CarRepository;

@Service
public class CarServiceImpl implements CarSerice {

	@Autowired
	private FipeService fipeService;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ClientService clientService;
	
	// Get FIPE brands
	@Override
	public List<FipeRequestResponseModel> getBrands() {
		return fipeService.getBrands();
	}

	// Get FIPE car models for a brand
	@Override
	public List<FipeRequestResponseModel> getModels(CarModel carModel) {
		return fipeService.getModels(carModel.getMarca()).getModelos();
	}

	// Get FIPE car years for a model
	@Override
	public List<FipeRequestResponseModel> getYears(CarModel carModel) {
		return fipeService.getModelYears(carModel.getMarca(), carModel.getModelo());
	}
	
	// Get FIPE car information 
	@Override
	public FipeCarModel getCarFromFipe(CarModel carModel) {
		return fipeService.getCarInformation(carModel.getMarca(), carModel.getModelo(), carModel.getAno());
	}
	
	// Lists all cars from a client
	@Override
	public List<CarModel> getCarsFromClient(String CPF) {
		List<CarModel> carList = carRepository.findByCPF(CPF);
		for (CarModel car : carList) {
			car.setRotationActive();
			car.setRotationDay();
		}
		return carList;
	}

	// Add new car for a client
	@Override
	public CarModel addCarToClient(CarModel carModel) throws IllegalArgumentException {
		if (!clientService.checkIfCPFExists(carModel.getCPF())) {
			throw new IllegalArgumentException("This CPF doesn't exist in the database");
		}
		CarModel newCar = carRepository.save(carModel);	
		newCar.setRotationActive();
		newCar.setRotationDay();
		return 	newCar;
	}
}
