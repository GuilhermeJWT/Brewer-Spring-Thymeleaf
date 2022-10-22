package br.com.systemsgs.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.systemsgs.model.ModelItemVenda;

public class TebelaItensVenda {
	
	private List<ModelItemVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal() {
		return itens.stream()
				.map(ModelItemVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}

}
