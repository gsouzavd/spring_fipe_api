package com.exemplo.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.demo.Model.CarModel;
import com.exemplo.demo.Model.ClientModel;
import com.exemplo.demo.Repository.ClientRepository;
import com.exemplo.demo.Service.CarSerice;
import com.exemplo.demo.Service.ClientService;
import com.exemplo.demo.Utils.HttpResponse;

@RestController
@RequestMapping(value = "/main")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CarSerice carService;
	
	@GetMapping(value = "/client")
	public HttpResponse getValidadeNewClient(@RequestBody ClientModel clientModel) {
		try {
			return new HttpResponse(HttpStatus.OK, clientService.checkClientUniqueness(clientModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao verificar cliente");
		}
	}
	
	@PutMapping(value = "/client")
	public HttpResponse putNewClient(@RequestBody ClientModel clientModel) {
		try {
			return new HttpResponse(HttpStatus.CREATED, clientService.addUser(clientModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
		}
	}
	
	@GetMapping(value = "/car/brands")
	public HttpResponse getCarBrands() {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getBrands());
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	@GetMapping(value = "/car/models")
	public HttpResponse getCarModels(@RequestBody CarModel carModel) {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getModels(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	@GetMapping(value = "/car/years")
	public HttpResponse getCarModelYears(@RequestBody CarModel carModel) {
		try {	
			return new HttpResponse(HttpStatus.OK, carService.getYears(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	@GetMapping(value = "/car/information")
	public HttpResponse getCarInformation(@RequestBody CarModel carModel) {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getCarFromFipe(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	
	@GetMapping(value = "/car/client")
	public HttpResponse getCarsFromClient(@RequestBody ClientModel clientModel) {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getCarsFromClient(clientModel.getCPF()));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	@PutMapping(value = "/car/client")
	public HttpResponse getCarsFromClient(@RequestBody CarModel carModel) {
		try {
			return new HttpResponse(HttpStatus.CREATED, carService.addCarToClient(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao adicionar carro");
		}
	}
}
