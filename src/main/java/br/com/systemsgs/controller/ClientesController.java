package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.systemsgs.enums.TipoPessoa;
import br.com.systemsgs.model.ModelCliente;
import br.com.systemsgs.repository.EstadosRepository;

@Controller
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@GetMapping("/novo")
	public ModelAndView novo(ModelCliente modelCliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tipoPessoa", TipoPessoa.values());
		mv.addObject("estados", estadosRepository.findAll());
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid ModelCliente modelCliente, BindingResult result) {
		if(result.hasErrors()) {
			return novo(modelCliente);
		}
		
		return new ModelAndView("redirect:/clientes/novo");
	}

}
