package br.com.systemsgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelCliente;
import br.com.systemsgs.repository.helper.cliente.ClientesQueries;

@Repository
public interface ClientesRepository extends JpaRepository<ModelCliente, Long>, ClientesQueries{

	public Optional<ModelCliente> findByCpfOuCnpj(String cpfOuCnpj);

}
