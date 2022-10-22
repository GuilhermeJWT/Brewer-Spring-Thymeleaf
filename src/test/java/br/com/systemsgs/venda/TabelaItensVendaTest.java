package br.com.systemsgs.venda;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.service.TabelaItensVenda;

public class TabelaItensVendaTest {
	
	private TabelaItensVenda tabelaItensVenda;
	
	@Before
	public void setUp() {
		this.tabelaItensVenda = new TabelaItensVenda();
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
		cerveja1.setCodigo(1L);
		BigDecimal valor1 = new BigDecimal("8.90");
		cerveja1.setValor(valor1);
		
		ModelCerveja cerveja2 = new ModelCerveja();
		cerveja2.setCodigo(2L);
		BigDecimal valor2 = new BigDecimal("4.99");
		cerveja2.setValor(valor2);
		
		tabelaItensVenda.adicionarItem(cerveja1, 1);
		tabelaItensVenda.adicionarItem(cerveja2, 2);
		
		assertEquals(new BigDecimal("18.88"), tabelaItensVenda.getValorTotal());
	}
	
	@Test
	public void deveManterTamanhoDaListaParaMesmasCervejas() throws Exception{
		ModelCerveja cerveja1 = new ModelCerveja();
		cerveja1.setCodigo(1L);
		cerveja1.setValor(new BigDecimal("4.50"));
		
		tabelaItensVenda.adicionarItem(cerveja1, 1);
		tabelaItensVenda.adicionarItem(cerveja1, 1);
		
		assertEquals(1, tabelaItensVenda.total());
		assertEquals(new BigDecimal("9.00"), tabelaItensVenda.getValorTotal());
	}

}
