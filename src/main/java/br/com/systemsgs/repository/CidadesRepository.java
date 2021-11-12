package br.com.systemsgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelCidade;

@Repository
public interface CidadesRepository extends JpaRepository<ModelCidade, Long>{
	
	public List<ModelCidade> findByEstadoCodigo(Long codigoEstado);

}
