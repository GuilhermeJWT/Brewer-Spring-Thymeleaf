package br.com.systemsgs.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class BrewerDialect extends AbstractProcessorDialect{

	public BrewerDialect() {
		super("Guilherme Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<IProcessor>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		
		return processadores;
	}

}
