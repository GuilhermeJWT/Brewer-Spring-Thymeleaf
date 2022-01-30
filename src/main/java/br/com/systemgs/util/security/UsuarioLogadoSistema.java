package br.com.systemgs.util.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.systemsgs.model.ModelUsuario;

public class UsuarioLogadoSistema extends User{
	
	private ModelUsuario modelUsuario;
	
	private static final long serialVersionUID = 1L;

	public UsuarioLogadoSistema(ModelUsuario modelUsuario, Collection<? extends GrantedAuthority> authorities) {
		super(modelUsuario.getEmail(), modelUsuario.getSenha(), authorities);
		this.modelUsuario = modelUsuario;
	}
	
	public ModelUsuario getModelUsuario() {
		return modelUsuario;
	}

}
