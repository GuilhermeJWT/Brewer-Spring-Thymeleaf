package br.com.systemsgs.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.systemgs.util.CervejaFilter;
import br.com.systemsgs.model.ModelCerveja;

public interface CervejasQuerie {
	
	 public Page<ModelCerveja> filtrar(CervejaFilter filtro, Pageable pageable);

}
