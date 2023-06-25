package com.br.gerenciamento.contatos.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/health")
public class ControllerHealth {
	private static Logger logger = LoggerFactory.getLogger(ControllerHealth.class);

	@ApiOperation(value = "verifica saude da aplicação")
	@GetMapping
	public String getHealth() {

		logger.info("Verificando a saude da aplicacao");

		LocalDateTime dataHoraAtual = LocalDateTime.now();

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		return dataHoraAtual.format(formato);

	}

}
