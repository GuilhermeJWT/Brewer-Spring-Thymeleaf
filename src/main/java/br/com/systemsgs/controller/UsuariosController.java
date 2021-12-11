package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemsgs.exception.EmailUsuarioJaCadastradoException;
import br.com.systemsgs.model.ModelUsuario;
import br.com.systemsgs.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
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
		
		try {
			usuarioService.salvarUsuario(modelUsuario);
		} catch (EmailUsuarioJaCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(modelUsuario);
		}
		
		attributes.addFlashAttribute("mensagem", "Usuário salvo com Sucesso");
		return new ModelAndView("redirect:/usuarios/novo");
	}

}
