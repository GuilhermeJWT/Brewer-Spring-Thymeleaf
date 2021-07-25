package br.com.systemsgs.converter;

import org.springframework.core.convert.converter.Converter;

import br.com.systemsgs.model.ModelEstilo;

public class EstiloConverter implements Converter<String, ModelEstilo> {

	@Override
	public ModelEstilo convert(String codigo) {
		ModelEstilo modelEstilo = new ModelEstilo();
		modelEstilo.setCodigo(Long.valueOf(codigo));

		return modelEstilo;
	}

}
