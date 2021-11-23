package br.com.systemsgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String nova() {
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ModelCidade> pesquisaPorCodigoEstado(@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado){
		return cidadesRepository.findByEstadoCodigo(codigoEstado);
	}
	
}
