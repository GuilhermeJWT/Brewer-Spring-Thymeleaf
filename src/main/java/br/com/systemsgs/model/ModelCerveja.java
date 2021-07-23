package br.com.systemsgs.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class ModelCerveja {
	
	@NotBlank(message = "Sku deve ser Informado!!!")
	private String sku;
	
	@NotBlank(message = "Nome deve ser Informado!!!")
	private String nome;
	
	@Size(min = 1, max = 50, message = "A Descrição deve estar entre 1 e 50 Caracteres!!!")
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
