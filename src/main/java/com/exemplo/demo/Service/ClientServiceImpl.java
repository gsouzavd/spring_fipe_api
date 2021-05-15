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
			return false;
		}
		return true;
	}

	@Override
	public ClientModel addUser(ClientModel clientModel) throws Exception {
		if (!this.checkClientUniqueness(clientModel)) {
			throw new Exception("A user with this e-mail or CPF already exists");
		}
		return this.clientRepository.save(clientModel);
	}
}
