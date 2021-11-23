package br.com.systemsgs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.systemgs.util.CidadeFilter;
import br.com.systemsgs.controller.page.PageWrapper;
import br.com.systemsgs.exception.NomeCidadeJaCadastradaException;
import br.com.systemsgs.model.ModelCidade;
import br.com.systemsgs.repository.CidadesRepository;
import br.com.systemsgs.repository.EstadosRepository;
import br.com.systemsgs.service.CidadeService;

@Controller
@RequestMapping(value = "/cidades")
public class CidadesController {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private CidadesRepository cidadesRepository;

	@Autowired
	private EstadosRepository estadoRepository;

	@RequestMapping("/nova")
	public ModelAndView nova(ModelCidade modelCidade) {
		ModelAndView mv = new ModelAndView("cidade/CadastroCidade");
		mv.addObject("estados", estadoRepository.findAll());

		return mv;
	}

	@PostMapping(value = "/nova")
	public ModelAndView salvar(@Valid ModelCidade modelCidade, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return nova(modelCidade);
		}

		try {
			cidadeService.salvar(modelCidade);
		} catch (NomeCidadeJaCadastradaException exception) {
			result.rejectValue("nome", exception.getMessage(), exception.getMessage());
			return nova(modelCidade);
		}

		attributes.addFlashAttribute("mensagem", "Cidade salva com sucesso!");
		return new ModelAndView("redirect:/cidades/nova");

	}

	@GetMapping
	public ModelAndView pesquisar(CidadeFilter cidadeFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cidade/PesquisaCidades");
		mv.addObject("estados", estadoRepository.findAll());

		PageWrapper<ModelCidade> paginaWrapper = new PageWrapper<>(cidadesRepository.filtrar(cidadeFilter, pageable),
				httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ModelCidade> pesquisarPorCodigoEstado(
			@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado) {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
		return cidadesRepository.findByEstadoCodigo(codigoEstado);
	}

}
