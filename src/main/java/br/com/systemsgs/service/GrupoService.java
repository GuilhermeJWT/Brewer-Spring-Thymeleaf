package br.com.systemsgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.repository.GruposRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GruposRepository gruposRepository;

	public Object findAll() {
		return gruposRepository.findAll();
	}

}
