package br.com.systemsgs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelCidade;
import br.com.systemsgs.model.ModelEstado;

@Repository
public interface CidadesRepository extends JpaRepository<ModelCidade, Long>{
	
	public List<ModelCidade> findByEstadoCodigo(Long codigoEstado);
	
	public Optional<ModelCidade> findByNomeAndEstado(String nome, ModelEstado modelEstado);

}
