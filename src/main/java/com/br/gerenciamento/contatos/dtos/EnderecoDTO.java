package com.br.gerenciamento.contatos.dtos;

import javax.validation.constraints.NotBlank;
import com.br.gerenciamento.contatos.model.Endereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {
	
	
	@ApiModelProperty(example = "Rua 15 de Novembro")
	@NotBlank(message="Rua não pode ser vazio !")
	private String rua;
	
	
	@ApiModelProperty(example = "111")
	@NotBlank(message="Numero não pode ser vazio !")
	private  Long numero;
	
	@ApiModelProperty(example = "Igara")
	@NotBlank(message="Bairro não pode ser vazio !")
	private String bairro;
	
	@ApiModelProperty(example = "Rio Grande do Sul")
	@NotBlank(message="Estado não pode ser vazio !")
	private String estado;
	
	@ApiModelProperty(example = "Porto Alegre")
	@NotBlank(message="Cidade não pode ser vazio !")
	private String cidade;
	
	@ApiModelProperty(example = "92410-700")
	@NotBlank(message="Cep não pode ser vazio !")
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
