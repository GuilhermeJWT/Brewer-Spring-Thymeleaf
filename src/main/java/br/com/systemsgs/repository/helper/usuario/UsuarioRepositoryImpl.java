package br.com.systemsgs.repository.helper.usuario;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.systemsgs.model.ModelUsuario;

public class UsuarioRepositoryImpl implements UsuariosQueries{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Optional<ModelUsuario> porEmailEAtivo(String email) {
		return manager.
				createQuery("from ModelUsuario where lower(email) = lower(:email) and ativo = true", ModelUsuario.class)
				.setParameter("email", email).getResultList().stream().findFirst();
	}

}
