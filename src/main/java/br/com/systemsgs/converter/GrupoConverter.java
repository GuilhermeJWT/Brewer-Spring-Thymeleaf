package br.com.systemsgs.converter;

import org.springframework.core.convert.converter.Converter;
import org.thymeleaf.util.StringUtils;

import br.com.systemsgs.model.ModelGrupo;

public class GrupoConverter implements Converter<String, ModelGrupo> {

	@Override
	public ModelGrupo convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			ModelGrupo grupo = new ModelGrupo();
			grupo.setCodigo(Long.valueOf(codigo));
			return grupo;
		}
		
		return null;
	}

}
