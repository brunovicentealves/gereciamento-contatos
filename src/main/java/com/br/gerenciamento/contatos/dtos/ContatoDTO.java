package com.br.gerenciamento.contatos.dtos;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.br.gerenciamento.contatos.model.Contato;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
	
	@NotBlank(message="Nome não pode ser vazio !")
	private String nome;
	
	@Email(message = "Email invalido!")
	private String email;
	
	@NotBlank(message="Telefone não pode ser vazio !")
	private String telefone;
	
	 @JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate  dataNascimento;
	
	
	public ContatoDTO(Contato contato) {
		super();
		this.nome = contato.getNome();
		this.email = contato.getEmail();
		this.telefone = contato.getTelefone();
		this.dataNascimento = contato.getDataNascimento();
	}


	
	
	
	
	

}
