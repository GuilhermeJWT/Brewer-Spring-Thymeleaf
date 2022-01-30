package br.com.systemsgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrosController {

	@GetMapping(value = "/404")
	public String paginaNaoEncontrada404() {
		return "404";
	}
	
	@RequestMapping(value = "/500")
	public String erroInternoNoServidor() {
		return "500";
	}
	
}
