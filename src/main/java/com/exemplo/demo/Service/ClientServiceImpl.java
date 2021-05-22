package com.exemplo.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.demo.Model.ClientModel;
import com.exemplo.demo.Repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public boolean checkClientUniqueness(ClientModel clientModel) {
		Long response = this.clientRepository.countClientsByCPFAndEmail(clientModel.getCPF(), clientModel.getEmail());
		if (response > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ClientModel addUser(ClientModel clientModel) throws IllegalArgumentException {
		if (this.checkClientUniqueness(clientModel)) {
			throw new IllegalArgumentException("A user with this e-mail or CPF already exists");
		}
		return this.clientRepository.save(clientModel);
	}

	@Override
	public boolean checkIfCPFExists(String CPF) {
		if (this.clientRepository.countClientsByCPF(CPF) > 0) {
			return true;
		}
		return false;
	}
}
