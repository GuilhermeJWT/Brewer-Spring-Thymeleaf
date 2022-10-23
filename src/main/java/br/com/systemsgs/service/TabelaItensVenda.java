package br.com.systemsgs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.model.ModelItemVenda;

/*SessionScope ou versão antiga a 4.2: @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS*/
@SessionScope
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
		
		Optional<ModelItemVenda> itemVendaOptional = buscarItenPorCerveja(modelCerveja);
		
		ModelItemVenda itemVenda =  null;
		if(itemVendaOptional.isPresent()){
			itemVenda = itemVendaOptional.get();
			itemVenda.setQuantidade(itemVenda.getQuantidade() + quantidade);
		}else {
			ModelItemVenda modelItemVenda = new ModelItemVenda();
			modelItemVenda.setCerveja(modelCerveja);
			modelItemVenda.setQuantidade(quantidade);
			modelItemVenda.setValorUnitario(modelCerveja.getValor());
			
			itens.add(0, modelItemVenda);
		}
	}
	
	public void alterarQuantidadeItens(ModelCerveja modelCerveja, Integer quantidade) {
		ModelItemVenda modelItemVenda = buscarItenPorCerveja(modelCerveja).get();
		modelItemVenda.setQuantidade(quantidade);
	}
	
	public int total() {
		return itens.size();
	}

	public List<ModelItemVenda> getItens() {
		return itens;
	}
	
	private Optional<ModelItemVenda> buscarItenPorCerveja(ModelCerveja modelCerveja){
		return itens.stream()
				.filter(i -> i.getCerveja().equals(modelCerveja))
				.findAny();
	}

}
