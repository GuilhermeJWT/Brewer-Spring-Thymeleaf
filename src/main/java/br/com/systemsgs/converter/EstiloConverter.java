package br.com.systemsgs.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.systemsgs.model.ModelEstilo;

public class EstiloConverter implements Converter<String, ModelEstilo> {

	@Override
	public ModelEstilo convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			ModelEstilo estilo = new ModelEstilo();
			estilo.setCodigo(Long.valueOf(codigo));
			return estilo;
		}
		
		return null;
	}

}
