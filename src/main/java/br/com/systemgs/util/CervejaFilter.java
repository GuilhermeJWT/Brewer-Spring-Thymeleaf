package br.com.systemgs.util;

import java.math.BigDecimal;

import br.com.systemsgs.enums.Origem;
import br.com.systemsgs.enums.Sabor;
import br.com.systemsgs.model.ModelEstilo;

public class CervejaFilter {
	
	private String sku;
	private String nome;
	private ModelEstilo estilo;
	private Sabor sabor;
	private Origem origem;
	private BigDecimal valorDe;
	private BigDecimal valorAte;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ModelEstilo getEstilo() {
		return estilo;
	}

	public void setEstilo(ModelEstilo estilo) {
		this.estilo = estilo;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public BigDecimal getValorDe() {
		return valorDe;
	}

	public void setValorDe(BigDecimal valorDe) {
		this.valorDe = valorDe;
	}

	public BigDecimal getValorAte() {
		return valorAte;
	}

	public void setValorAte(BigDecimal valorAte) {
		this.valorAte = valorAte;
	}
	
}
