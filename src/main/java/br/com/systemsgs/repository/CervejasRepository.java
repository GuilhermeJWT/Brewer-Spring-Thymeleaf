package br.com.systemsgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelCerveja;

@Repository
public interface CervejasRepository extends JpaRepository<ModelCerveja, Long>{

}
