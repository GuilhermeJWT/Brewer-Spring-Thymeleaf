package br.com.systemsgs.repository.helper.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.systemgs.util.ClienteFilter;
import br.com.systemsgs.model.ModelCliente;

public interface ClientesQueries {
	
	public Page<ModelCliente> filtrar(ClienteFilter filtro, Pageable pageable);

}
