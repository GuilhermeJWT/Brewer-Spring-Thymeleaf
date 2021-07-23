package br.com.systemsgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CervejaController {
	
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/testando";
	}

}
