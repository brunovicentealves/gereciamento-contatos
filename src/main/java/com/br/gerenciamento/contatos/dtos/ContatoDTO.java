package com.br.gerenciamento.contatos.dtos;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class ContatoDTO {
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private LocalDate  dataNascimento;
	
	

}
