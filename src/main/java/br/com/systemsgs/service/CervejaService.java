package br.com.systemsgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemgs.util.CervejaSalvaEvent;
import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.repository.CervejasRepository;

@Service
@EnableJpaRepositories(basePackages = "br.com.systemsgs.repository")
public class CervejaService {
	
	@Autowired
	private CervejasRepository cervejasRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Transactional
	public void salvar(ModelCerveja modelCerveja) {
		cervejasRepository.save(modelCerveja);
		
		publisher.publishEvent(new CervejaSalvaEvent(modelCerveja));
	}

	public List<ModelCerveja> listaCervejas() {
		return cervejasRepository.findAll();
	}

}
