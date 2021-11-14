package br.com.systemgs.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.systemsgs.model.ModelCliente;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<ModelCliente>{

	@Override
	public List<Class<?>> getValidationGroups(ModelCliente modelCliente) {
		List<Class<?>> grupos = new ArrayList<>();
		
		grupos.add(ModelCliente.class);
		
		if(isPessoaSelecionada(modelCliente)) {
			grupos.add(modelCliente.getTipoPessoa().getGrupo());
		}
		
		return grupos;
	}

	private boolean isPessoaSelecionada(ModelCliente modelCliente) {
		return modelCliente != null && modelCliente.getTipoPessoa() != null;
	}

}
