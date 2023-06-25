package com.br.gerenciamento.contatos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.gerenciamento.contatos.dtos.ContatoDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/contato")
public class ControllerContatos {
	
	private static Logger logger  = LoggerFactory.getLogger(ControllerContatos.class);
	
	@ApiOperation(value = "Adciona novo contato.")
	@PostMapping(value="/cadastro")
	public  ResponseEntity<?>  cadastrarContato(@RequestBody ContatoDTO contato){
		
		logger.info("Iniciando Cadastro de contatos ");
		
		return null;
	}
	
	
	@ApiOperation(value = "Listar todos os contatos.")
	@GetMapping(value="/listar")
	public  ResponseEntity<?> listarTodosContatos(){
		
		logger.info("Iniciando Listar de contatos ");
		
		return null;
	}
	
	
	
	@ApiOperation(value = "Alterar contato especifico.")
	@PutMapping(value= "/alterar")
	public ResponseEntity<?> alterarContato(){
		
		logger.info("Iniciando Alterar contatos ");
		
		return null;
	}
	
	@ApiOperation(value = "Deletar contato especifico.")
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deletarContato (@PathVariable Long id ){
		
		logger.info("Iniciando Deletar contatos ");
		
		
		return ResponseEntity.ok("Deletado com sucesso Contato");
	}
	
	

}
