package com.br.gerenciamento.contatos.dtos;

import com.br.gerenciamento.contatos.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
	
	private String rua;
	
	private  Long numero;
	
	private String bairro;
	
	private String estado;
	
	private String cidade;
	
	private String cep;

	public EnderecoDTO(Endereco endereco) {
		super();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.cep = endereco.getCep();
	}
	
	
	

}
