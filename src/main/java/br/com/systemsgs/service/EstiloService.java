package br.com.systemsgs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemsgs.exception.NomeEstiloJaCadastradoException;
import br.com.systemsgs.model.ModelEstilo;
import br.com.systemsgs.repository.EstilosRepository;

@Service
public class EstiloService {
	
	@Autowired
	private EstilosRepository estilosRepository;
	
	@Transactional
	public ModelEstilo salvar(ModelEstilo modelEstilo) {
		
		Optional<ModelEstilo> estiloOptional = estilosRepository.findByNomeIgnoreCase(modelEstilo.getNome());
		
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome do Estilo já Cadastrado!!!");
		}
		
		return estilosRepository.saveAndFlush(modelEstilo);
	}
}
