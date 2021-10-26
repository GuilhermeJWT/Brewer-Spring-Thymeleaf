package br.com.systemsgs.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.systemgs.util.EstiloFilter;
import br.com.systemsgs.model.ModelEstilo;

public interface EstilosQueries {

	public Page<ModelEstilo> filtrar(EstiloFilter filtro, Pageable pageable);
	
}
