package br.com.systemsgs.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@GetMapping
	public String login(@AuthenticationPrincipal User user) {
		
		if(user != null) {
			return "redirect:/cervejas";
		}
		
		return "Login";
	}
	
	@GetMapping(value = "/403")
	public String acessoNegado() {
		return "403";
	}

}
