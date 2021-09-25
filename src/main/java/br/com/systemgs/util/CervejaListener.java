package br.com.systemgs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CervejaListener {

	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#evento.temFoto()")
	public void cervejaSalva(CervejaSalvaEvent evento) {
		fotoStorage.salvar(evento.getModelCerveja().getFoto());
	}

}
