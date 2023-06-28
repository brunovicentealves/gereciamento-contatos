package com.br.gerenciamento.contatos.testUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.br.gerenciamento.contatos.dtos.ContatoDTO;
import com.br.gerenciamento.contatos.dtos.EnderecoDTO;
import com.br.gerenciamento.contatos.model.Contato;
import com.br.gerenciamento.contatos.model.Endereco;

public class TestUtil {
	
	public static Endereco endereco () {
		
		
		return Endereco.builder()
						.id(1L)
						 .bairro("Igara")
						 .rua("Rua 15")
						 .cidade("Porto Alegre")
						 .numero(118L)
						 .estado("RS")
						 .cep("91410-700")
						 .build();
	}
	
	
public static EnderecoDTO enderecoDTO () {
		
		
		return EnderecoDTO.builder()
						 .bairro("Igara")
						 .rua("Rua 15")
						 .cidade("Porto Alegre")
						 .numero(118L)
						 .estado("RS")
						 .cep("91410-700")
						 .build();
	}
	
	
	
	public static Contato contato () {
 
	
	return Contato.builder()
					.id(1L)
					.nome("Pedro")
					.email("pedro@gmail.com")
					.telefone("51-99553-5549")
					.dataNascimento(LocalDate.now())
					.enderecos(List.of())
					.build();

	}
	
	
	public static Contato contatoBadRequest () {
		 
		
		return Contato.builder()
						.id(3L)
						.nome("Pedro")
						.email("pedro@gmail.com")
						.telefone("51-99553-5549")
						.dataNascimento(LocalDate.now())
						.enderecos(List.of())
						.build();

		}
	
	public static Contato contatoCompleto () {
	
	return Contato.builder()
					.id(1L)
					.nome("Pedro")
					.email("pedro@gmail.com")
					.telefone("51-99553-5549")
					.dataNascimento(LocalDate.now())
					.enderecos(List.of(endereco()))
					.build();
	
	}
	
	public static Optional<Contato> contatoOptional () {
	
	return Optional.ofNullable(contato());
	
	}
	
	
	public static Optional<Endereco> enderecoOptional () {
		
		return Optional.ofNullable(endereco());
		
		}
	
	public static Optional<Contato> contatoOptionalCompleto () {
	
	return Optional.ofNullable(contatoCompleto());
	}
	
	public static ContatoDTO contatoDTO () {
	
	return ContatoDTO.builder()
					.nome("Pedro")
					.email("pedro@gmail.com")
					.telefone("51-99553-5549")
					.dataNascimento(LocalDate.now())
					.build();
	}
}
