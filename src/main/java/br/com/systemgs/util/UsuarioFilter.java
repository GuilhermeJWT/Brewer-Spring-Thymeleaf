package br.com.systemgs.util;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.systemsgs.model.ModelGrupo;

public class UsuarioFilter {
	
	private String nome;
	private String email;
	private List<ModelGrupo> grupos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ModelGrupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<ModelGrupo> grupos) {
		this.grupos = grupos;
	}

}
