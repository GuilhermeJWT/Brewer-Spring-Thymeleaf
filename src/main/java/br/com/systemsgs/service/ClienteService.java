package br.com.systemsgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.model.ModelCliente;
import br.com.systemsgs.repository.ClientesRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository clientesRepository;

	public void salvarCliente(ModelCliente modelCliente) {
		clientesRepository.save(modelCliente);
	}
	
}
