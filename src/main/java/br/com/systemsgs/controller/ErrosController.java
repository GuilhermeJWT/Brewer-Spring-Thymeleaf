package br.com.systemsgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrosController {

	@GetMapping(value = "/404")
	public String paginaNaoEncontrada404() {
		return "404";
	}
	
}
