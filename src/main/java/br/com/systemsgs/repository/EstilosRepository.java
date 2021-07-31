package br.com.systemsgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelEstilo;

@Repository
public interface EstilosRepository extends JpaRepository<ModelEstilo, Long>{

	public Optional<ModelEstilo> findByNomeIgnoreCase(String nome);
	
}
