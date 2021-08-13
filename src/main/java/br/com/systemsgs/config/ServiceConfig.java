package br.com.systemsgs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.systemgs.util.FotoStorage;
import br.com.systemsgs.service.CervejaService;

@Configuration
@ComponentScan(basePackageClasses = CervejaService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new SalvaFotoLocal();
	}

}
