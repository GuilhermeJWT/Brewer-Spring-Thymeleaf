package br.com.systemsgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.systemsgs.enums.TipoPessoa;

@Controller
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tipoPessoa", TipoPessoa.values());
		
		return mv;
	}

}
