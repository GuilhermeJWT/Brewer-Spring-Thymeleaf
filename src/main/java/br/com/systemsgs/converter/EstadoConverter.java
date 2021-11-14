package br.com.systemsgs.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.systemsgs.model.ModelEstado;

public class EstadoConverter implements Converter<String, ModelEstado> {

	@Override
	public ModelEstado convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			ModelEstado estado = new ModelEstado();
			estado.setCodigo(Long.valueOf(codigo));
			return estado;
		}
		
		return null;
	}

}
