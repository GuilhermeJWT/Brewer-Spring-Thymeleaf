package br.com.systemsgs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemsgs.exception.NomeCidadeJaCadastradaException;
import br.com.systemsgs.model.ModelCidade;
import br.com.systemsgs.repository.CidadesRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadesRepository cidadesRepository;
	
	@Transactional
	public void salvar(ModelCidade modelCidade) {
		Optional<ModelCidade> cidadeExistente = cidadesRepository.findByNomeAndEstado(modelCidade.getNome(), modelCidade.getEstado());
		
		if(cidadeExistente.isPresent()) {
			throw new NomeCidadeJaCadastradaException("Nome de Cidade já Cadastrado!");
		}
		
		cidadesRepository.save(modelCidade);
		
	}

}
