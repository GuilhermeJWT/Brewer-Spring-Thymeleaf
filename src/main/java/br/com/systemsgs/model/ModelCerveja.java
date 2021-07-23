package br.com.systemsgs.model;

import org.hibernate.validator.constraints.NotBlank;

public class ModelCerveja {
	
	@NotBlank(message = "SKU Obrigatório")
	private String sku;
	
	private String nome;
	
	private String descricao;
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
