package br.com.systemgs.util;

import org.springframework.util.StringUtils;

import br.com.systemsgs.model.ModelCerveja;

public class CervejaSalvaEvent {
	
	private ModelCerveja modelCerveja;
	
	public ModelCerveja getModelCerveja() {
		return modelCerveja;
	}

	public CervejaSalvaEvent(ModelCerveja modelCerveja) {
		this.modelCerveja = modelCerveja;
	}
	
	public boolean temFoto() {
		return !StringUtils.isEmpty(modelCerveja.getFoto());
	}
	
}
