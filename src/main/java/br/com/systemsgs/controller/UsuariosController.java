package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemgs.util.UsuarioFilter;
import br.com.systemsgs.enums.StatusUsuario;
import br.com.systemsgs.exception.EmailUsuarioJaCadastradoException;
import br.com.systemsgs.model.ModelUsuario;
import br.com.systemsgs.repository.GruposRepository;
import br.com.systemsgs.service.GrupoService;
import br.com.systemsgs.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private GruposRepository grupoRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo(ModelUsuario modelUsuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupoRepository.findAll());
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
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter) {
		ModelAndView mv = new ModelAndView("/usuario/PesquisaUsuarios");
		mv.addObject("usuarios", usuarioService.filtra(usuarioFilter));
		mv.addObject("grupos", grupoService.findAll());
		return mv;
	}
	
	@PutMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarStatus(@RequestParam("codigos[]") Long[] codigos, @RequestParam("status") StatusUsuario statusUsuario) {
		usuarioService.alterarStatus(codigos, statusUsuario);
	}

}
