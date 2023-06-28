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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.br.gerenciamento.contatos.dtos.EnderecoDTO;
import com.br.gerenciamento.contatos.service.EnderecoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	private static Logger logger = LoggerFactory.getLogger(ControllerContatos.class);
	
	@ApiOperation(value = "Adciona novo endereco.")
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarContato(@RequestParam Long contatoId,@RequestBody @Valid EnderecoDTO endereco) {

		logger.info("Iniciando Cadastro de Endereco");
		String response = service.adcionarEndereco(endereco,contatoId);

		logger.info("Finalizando Cadastro de Endereco ");

		return ResponseEntity.ok(response);
	}
	
	
	@ApiOperation(value = "Listar todos os Enderecos do Contato.")
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarTodosContatos(@RequestParam Long contatoId) {

		logger.info("Iniciando Listar de Enderecos ");

		List<EnderecoDTO> responseEndereco = service.buscarTodosEnderecosPorContatoId(contatoId);

		logger.info("Finalizando Listar de Enderecos ");

		return ResponseEntity.ok(responseEndereco);
	}
	
	
	@ApiOperation(value = "Deletar Endereco de um contato")
	@DeleteMapping(value = "/delete/{enderecoId}")
	public ResponseEntity<String> deletarContato(@PathVariable Long enderecoId) {

		logger.info("Iniciando Deletar Enderecos por id ");

		String messageResponse = service.deleteContato(enderecoId);

		logger.info("Finalizando Deletar Enderecos por id ");

		return ResponseEntity.ok(messageResponse);
	}


	
	

}
