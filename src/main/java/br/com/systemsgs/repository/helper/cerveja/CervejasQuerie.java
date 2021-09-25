package br.com.systemsgs.repository.helper.cerveja;

import java.util.List;

import br.com.systemgs.util.CervejaFilter;
import br.com.systemsgs.model.ModelCerveja;

public interface CervejasQuerie {
	
	 public List<ModelCerveja> filtrar(CervejaFilter filtro);

}
