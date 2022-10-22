package br.com.systemsgs.venda;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.systemsgs.model.ModelCerveja;

public class TabelaItensVendaTest {
	
	private TebelaItensVenda tabelaItensVenda;
	
	@Before
	public void setUp() {
		this.tabelaItensVenda = new TebelaItensVenda();
	}
	
	@Test
	public void deveCalcularValorTotalSemItens() throws Exception {
		assertEquals(BigDecimal.ZERO, tabelaItensVenda.getValorTotal());
	}
	
	@Test
	public void deveCalcularValorTotalComUmItem() throws Exception {
		ModelCerveja modelCerveja = new ModelCerveja();
		BigDecimal valor = new BigDecimal("8.90");
		modelCerveja.setValor(valor);
		
		tabelaItensVenda.adicionarItem(modelCerveja, 1);
		
		assertEquals(valor, tabelaItensVenda.getValorTotal());
	}
	
	@Test
	public void deveCalcularValorTotalComVariosItens() throws Exception {
		ModelCerveja cerveja1 = new ModelCerveja();
		BigDecimal valor1 = new BigDecimal("8.90");
		cerveja1.setValor(valor1);
		
		ModelCerveja cerveja2 = new ModelCerveja();
		BigDecimal valor2 = new BigDecimal("4.99");
		cerveja2.setValor(valor2);
		
		tabelaItensVenda.adicionarItem(cerveja1, 1);
		tabelaItensVenda.adicionarItem(cerveja2, 2);
		
		assertEquals(new BigDecimal("18.88"), tabelaItensVenda.getValorTotal());
	}

}
