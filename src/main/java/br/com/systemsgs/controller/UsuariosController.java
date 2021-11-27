package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemsgs.model.ModelUsuario;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {
	
	@RequestMapping("/novo")
	public ModelAndView novo(ModelUsuario modelUsuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid ModelUsuario modelUsuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(modelUsuario);
		}
		
		attributes.addFlashAttribute("mensagem", "Usuário salvo com Sucesso");
		return new ModelAndView("redirect:/usuarios/novo");
	}

}
