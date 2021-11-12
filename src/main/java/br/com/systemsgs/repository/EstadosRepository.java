package br.com.systemsgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelEstado;

@Repository
public interface EstadosRepository extends JpaRepository<ModelEstado, Long>{

}
