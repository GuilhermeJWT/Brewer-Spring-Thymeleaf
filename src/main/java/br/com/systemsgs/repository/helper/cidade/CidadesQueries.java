package br.com.systemsgs.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.systemgs.util.CidadeFilter;
import br.com.systemsgs.model.ModelCidade;

public interface CidadesQueries {
	
	public Page<ModelCidade> filtrar(CidadeFilter filtro, Pageable pageable);

}
