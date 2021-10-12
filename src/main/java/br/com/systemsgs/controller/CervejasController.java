package br.com.systemsgs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemgs.util.CervejaFilter;
import br.com.systemsgs.controller.page.PageWrapper;
import br.com.systemsgs.enums.Origem;
import br.com.systemsgs.enums.Sabor;
import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.repository.CervejasRepository;
import br.com.systemsgs.repository.EstilosRepository;
import br.com.systemsgs.service.CervejaService;

@Controller
@RequestMapping(value = "/cervejas")
public class CervejasController {
	
	@Autowired
	private CervejaService cervejaService;
	
	@Autowired
	private CervejasRepository cervejaRepository;
	
	@Autowired
	private EstilosRepository estilosRepository;
	
	@RequestMapping(value = "/novo")
	public ModelAndView novo(ModelCerveja modelCerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		mv.addObject("estilos", estilosRepository.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid ModelCerveja modelCerveja, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(modelCerveja);
		}
		
		cervejaService.salvar(modelCerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja Salva com Sucesso!");

		return new ModelAndView("redirect:/cervejas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult bindingResult, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		mv.addObject("estilos", estilosRepository.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		
		PageWrapper<ModelCerveja> paginaWrapper = new PageWrapper<>(cervejaRepository.filtrar(cervejaFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

}
