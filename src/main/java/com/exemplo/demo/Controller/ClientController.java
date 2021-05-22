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

	// GET - Checks if the client already exists in the system
	// @param - cpf - String - client CPF, format: nnn.nnn.nnn-nn
	// @param - email - String - client e-mail
	// @return - true if client exist, false if doesn't 
	@GetMapping(value = "/client")
	public HttpResponse getValidadeNewClient(@RequestBody ClientModel clientModel) {
		try {
			return new HttpResponse(HttpStatus.OK, clientService.checkClientUniqueness(clientModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao verificar cliente");
		}
	}
	
	// PUT - Add new client to the database
	// @param - Client Model table values
	// @returns - Informations added to the database
	@PutMapping(value = "/client")
	public HttpResponse addNewClient(@RequestBody ClientModel clientModel) {
		try {
			return new HttpResponse(HttpStatus.CREATED, clientService.addUser(clientModel));
		} catch(IllegalArgumentException ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}  catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao adicionar usuário");
		}
	}
	
	// GET - Get FIPE system available car brands and codes
	// @param - None
	// @returns - FIPE brands and values
	@GetMapping(value = "/car/brands")
	public HttpResponse getCarBrands() {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getBrands());
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	// GET - Get FIPE system available car brands and codes
	// @param - brand - FIPE brand code
	// @returns - FIPE models and values
	@GetMapping(value = "/car/models")
	public HttpResponse getCarModels(@RequestBody CarModel carModel) {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getModels(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	// GET - Get FIPE system available car brands and codes
	// @param - brand - FIPE brand code
	// @param - model - FIPE model code
	// @returns - FIPE model years and values
	@GetMapping(value = "/car/years")
	public HttpResponse getCarModelYears(@RequestBody CarModel carModel) {
		try {	
			return new HttpResponse(HttpStatus.OK, carService.getYears(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	// GET - Get FIPE car information
	// @param - brand - FIPE brand code
	// @param - model - FIPE model code
	// @param - year - FIPE year code
	// @returns - FIPE car information
	@GetMapping(value = "/car/information")
	public HttpResponse getCarInformation(@RequestBody CarModel carModel) {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getCarFromFipe(carModel));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	
	// GET - List all cars from a client and its information
	// @param - cpf - client CPF
	// @returns - List of the client's FIPE car information and rotation
	@GetMapping(value = "/car/client")
	public HttpResponse getCarsFromClient(@RequestBody ClientModel clientModel) {
		try {
			return new HttpResponse(HttpStatus.OK, carService.getCarsFromClient(clientModel.getCPF()));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
	
	// PUT - Add new car to the client table
	// @param - Car Model - information of the car table
	// @returns - Car Model created on the system and it's and rotation
	@PutMapping(value = "/car/client")
	public HttpResponse addCarToClient(@RequestBody CarModel carModel) {
		try {
			return new HttpResponse(HttpStatus.CREATED, carService.addCarToClient(carModel));
		} catch(IllegalArgumentException ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		} catch(Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao adicionar carro");
		}
	}
}
