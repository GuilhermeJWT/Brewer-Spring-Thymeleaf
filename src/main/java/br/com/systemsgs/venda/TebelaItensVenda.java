package br.com.systemsgs.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.model.ModelItemVenda;

public class TebelaItensVenda {
	
	private List<ModelItemVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal() {
		return itens.stream()
				.map(ModelItemVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
	
	public void adicionarItem(ModelCerveja modelCerveja, Integer quantidade) {
		ModelItemVenda modelItemVenda = new ModelItemVenda();
		modelItemVenda.setCerveja(modelCerveja);
		modelItemVenda.setQuantidade(quantidade);
		modelItemVenda.setValorUnitario(modelCerveja.getValor());
		
		itens.add(modelItemVenda);
	}

}
