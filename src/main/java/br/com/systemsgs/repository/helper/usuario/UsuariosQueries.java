package br.com.systemsgs.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import br.com.systemsgs.model.ModelUsuario;

public interface UsuariosQueries {

	public Optional<ModelUsuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(ModelUsuario modelUsuario);
	
}
