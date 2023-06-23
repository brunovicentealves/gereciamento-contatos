package com.br.gerenciamento.contatos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerContatos {
	
	@GetMapping("/health")
	public String getHealth() {
		return "Application is up and running";
		
	}

}
