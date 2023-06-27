package com.br.gerenciamento.contatos.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.gerenciamento.contatos.dtos.ContatoDTO;
import com.br.gerenciamento.contatos.service.ContatoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contato")
public class ControllerContatos {
	@Autowired
	private ContatoService service;

	private static Logger logger = LoggerFactory.getLogger(ControllerContatos.class);

	@ApiOperation(value = "Adciona novo contato.")
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarContato(@RequestBody @Valid ContatoDTO contato) {

		logger.info("Iniciando Cadastro de contatos ");
		String response = service.adcionarContato(contato);

		logger.info("Finalizando Cadastro de contatos ");

		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Listar todos os contatos.")
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarTodosContatos() {

		logger.info("Iniciando Listar de contatos ");

		List<ContatoDTO> responseContato = service.buscarTodosContatos();

		logger.info("Finalizando Listar de contatos ");

		return ResponseEntity.ok(responseContato);
	}

	@ApiOperation(value = "Alterar contato especifico.")
	@PutMapping(value = "/alterar/{id}")
	public ResponseEntity<?> alterarContato(@RequestBody ContatoDTO contato, @PathVariable Long id ) {

		logger.info("Iniciando Alterar contatos ");
		
		ContatoDTO responseContato = service.alterarContato(contato, id);
		
		logger.info("Finalizando Alterar contatos ");

		return ResponseEntity.ok(responseContato);
	}

	@ApiOperation(value = "Deletar contato especifico.")
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletarContato(@PathVariable Long id) {

		logger.info("Iniciando Deletar contatos ");

		String messageResponse = service.deleteContato(id);

		logger.info("Finalizando Deletar contatos ");

		return ResponseEntity.ok(messageResponse);
	}

}
