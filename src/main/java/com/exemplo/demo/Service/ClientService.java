package com.exemplo.demo.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.Model.ClientModel;

@Component
public interface ClientService {
	
	public boolean checkClientUniqueness(ClientModel clientModel);
	public ClientModel addUser(ClientModel clientModel) throws Exception;
	
	
}
