package br.com.systemsgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.systemsgs.model.ModelCerveja;
import br.com.systemsgs.repository.CervejasRepository;
import br.com.systemsgs.service.TabelaItensVenda;

@Controller
@RequestMapping("/vendas")
public class VendasController {
	
	@Autowired
	private TabelaItensVenda tabelaItensVenda;
	
	@Autowired
	private CervejasRepository cervejasRepository;
	
	@GetMapping("/nova")
	public String nova() {
		return "venda/CadastroVenda";
	}
	
	@PostMapping("/item")
	public @ResponseBody String adicionarItem(Long codigoCerveja) {
		ModelCerveja modelCerveja = cervejasRepository.findOne(codigoCerveja);
		tabelaItensVenda.adicionarItem(modelCerveja, 1);
		
		return "Item Adicionado!";
	}

}
