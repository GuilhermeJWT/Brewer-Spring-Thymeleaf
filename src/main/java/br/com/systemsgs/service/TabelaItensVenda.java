package br.com.systemsgs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.model.ModelItemVenda;

@Service
public class TabelaItensVenda {
	
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
	
	public int total() {
		return itens.size();
	}

}
