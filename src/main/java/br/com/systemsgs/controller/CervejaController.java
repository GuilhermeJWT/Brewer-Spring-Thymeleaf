package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.systemsgs.model.ModelCerveja;

@Controller
public class CervejaController {
	
	@RequestMapping(value = "/cervejas/novo")
	public String novo() {
		return "cerveja/testando";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid ModelCerveja modelCerveja, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("tem sim");
		}
		
		return "cerveja/testando";
	}

}
