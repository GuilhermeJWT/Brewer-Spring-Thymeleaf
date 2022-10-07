package br.com.systemsgs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemgs.util.ClienteFilter;
import br.com.systemsgs.controller.page.PageWrapper;
import br.com.systemsgs.enums.TipoPessoa;
import br.com.systemsgs.exception.CpfCnpjClienteJaCadastradoException;
import br.com.systemsgs.model.ModelCliente;
import br.com.systemsgs.repository.ClientesRepository;
import br.com.systemsgs.repository.EstadosRepository;
import br.com.systemsgs.service.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClientesRepository clientesRepository;
	
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
		
		try {
			clienteService.salvarCliente(modelCliente);
		} catch (CpfCnpjClienteJaCadastradoException excption) {
			result.rejectValue("cpfOuCnpj", excption.getMessage(), excption.getMessage());
			return novo(modelCliente);
		}
		attributes.addFlashAttribute("mensagem", "Cliente Salvo com Sucesso!!!");
		return new ModelAndView("redirect:/clientes/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ClienteFilter clienteFilter, BindingResult result, @PageableDefault(size = 3) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cliente/PesquisaClientes");
		mv.addObject("tipoPessoa", TipoPessoa.values());
		
		PageWrapper<ModelCliente> pageWrapper = new PageWrapper<>(clientesRepository.filtrar(clienteFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		
		return mv;
	}
	
	@GetMapping(value = "/pesquisar")
	public @ResponseBody List<ModelCliente> pesquisarPorNome(String nome){
		validarTamanhoNome(nome);
		return clientesRepository.findByNomeStartingWithIgnoreCase(nome);
	}

	private void validarTamanhoNome(String nome) {
		if(StringUtils.isEmpty(nome) || nome.length() <3) {
			throw new IllegalArgumentException();
		}
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Void> tratarIllegalArgumentException (IllegalArgumentException exception){
		return ResponseEntity.badRequest().build();
	}

}
