package br.com.systemsgs.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.systemgs.util.UsuarioFilter;
import br.com.systemsgs.model.ModelUsuario;

public interface UsuariosQueries {

	public Optional<ModelUsuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(ModelUsuario modelUsuario);
	
	public Page<ModelUsuario> filtrar(UsuarioFilter filtro, Pageable pageable);
	
}
