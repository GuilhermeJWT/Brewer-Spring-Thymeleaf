package br.com.systemgs.util;

import br.com.systemsgs.model.ModelEstado;

public class CidadeFilter {
	
	private ModelEstado estado;
	private String nome;
	
	public ModelEstado getEstado() {
		return estado;
	}
	
	public void setEstado(ModelEstado estado) {
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
