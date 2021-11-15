package br.com.systemsgs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.exception.CpfCnpjClienteJaCadastradoException;
import br.com.systemsgs.model.ModelCliente;
import br.com.systemsgs.repository.ClientesRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository clientesRepository;

	public void salvarCliente(ModelCliente modelCliente) {
		
		Optional<ModelCliente> clienteExistente = clientesRepository.findByCpfOuCnpj(modelCliente.getCpfCnpjSemFormatacao());
		
		if(clienteExistente.isPresent()) {
			throw new CpfCnpjClienteJaCadastradoException("CPF/CNPJ já Cadastrado");
		}
		
		clientesRepository.save(modelCliente);
	}
	
}
