package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.systemsgs.enums.Origem;
import br.com.systemsgs.enums.Sabor;
import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.repository.EstilosRepository;
import br.com.systemsgs.service.CervejaService;

@Controller
public class CervejasController {
	
	@Autowired
	private CervejaService cervejaService;
	
	@Autowired
	private EstilosRepository estilosRepository;

	@RequestMapping(value = "/cervejas/novo")
	public ModelAndView novo(ModelCerveja modelCerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		mv.addObject("estilos", estilosRepository.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid ModelCerveja modelCerveja) {
		
		/*
		if(result.hasErrors()) {
			return novo(modelCerveja);
		}
		*/
		
		
		cervejaService.salvar(modelCerveja);

		return new ModelAndView("redirect:/cervejas/novo");
	}

}
