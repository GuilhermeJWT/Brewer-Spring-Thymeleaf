package br.com.systemsgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<ModelUsuario, Long>{
	
	Optional<ModelUsuario> findByEmail(String email);

}
