package br.com.systemsgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelGrupo;

@Repository
public interface GruposRepository extends JpaRepository<ModelGrupo, Long>{

}
