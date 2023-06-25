package com.br.gerenciamento.contatos.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO {
	
	private String rua;
	
	private  Long numero;
	
	private String bairro;
	
	private String estado;
	
	private String cidade;
	
	private String cep;
	

}
