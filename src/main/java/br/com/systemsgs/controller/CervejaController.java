package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemsgs.model.ModelCerveja;

@Controller
public class CervejaController {
	
	@RequestMapping(value = "/cervejas/novo")
	public String novo(ModelCerveja modelCerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid ModelCerveja modelCerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(modelCerveja);
		}
		
		return "redirect:/cerveja/CadastroCerveja";
	}

}
