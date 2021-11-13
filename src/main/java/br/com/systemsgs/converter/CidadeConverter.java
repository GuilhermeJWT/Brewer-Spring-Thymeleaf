package br.com.systemsgs.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.systemsgs.model.ModelCidade;

public class CidadeConverter implements Converter<String, ModelCidade> {

	@Override
	public ModelCidade convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			ModelCidade cidade = new ModelCidade();
			cidade.setCodigo(Long.valueOf(codigo));
			return cidade;
		}
		
		return null;
	}

}
