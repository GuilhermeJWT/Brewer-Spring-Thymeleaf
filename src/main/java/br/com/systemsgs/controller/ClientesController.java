package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemsgs.enums.TipoPessoa;
import br.com.systemsgs.model.ModelCliente;
import br.com.systemsgs.repository.EstadosRepository;
import br.com.systemsgs.service.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/novo")
	public ModelAndView novo(ModelCliente modelCliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tipoPessoa", TipoPessoa.values());
		mv.addObject("estados", estadosRepository.findAll());
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid ModelCliente modelCliente, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(modelCliente);
		}
		
		clienteService.salvarCliente(modelCliente);
		attributes.addFlashAttribute("mensagem", "Cliente Salvo com Sucesso!!!");
		return new ModelAndView("redirect:/clientes/novo");
	}

}
