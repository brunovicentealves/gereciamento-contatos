package com.br.gerenciamento.contatos.dtos;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.br.gerenciamento.contatos.model.Contato;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
	
	@ApiModelProperty(example = "John Doe")
	@NotBlank(message="Nome não pode ser vazio !")
	private String nome;
	
	@ApiModelProperty(example = "JohnDoe@gmail.com")
	@Email(message = "Email invalido!")
	private String email;
	
	@ApiModelProperty(example = "51-99103-7271")
	@NotBlank(message="Telefone não pode ser vazio !")
	private String telefone;
	
	@ApiModelProperty(example = "16/11/1995")
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
