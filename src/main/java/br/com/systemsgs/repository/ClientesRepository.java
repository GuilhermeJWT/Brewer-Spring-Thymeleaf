package br.com.systemsgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelCliente;

@Repository
public interface ClientesRepository extends JpaRepository<ModelCliente, Long>{

	public Optional<ModelCliente> findByCpfOuCnpj(String cpfOuCnpj);

}
