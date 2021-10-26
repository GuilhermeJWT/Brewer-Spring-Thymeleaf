package br.com.systemsgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelEstilo;
import br.com.systemsgs.repository.helper.estilo.EstilosQueries;

@Repository
public interface EstilosRepository extends JpaRepository<ModelEstilo, Long>, EstilosQueries{

	public Optional<ModelEstilo> findByNomeIgnoreCase(String nome);
	
}
