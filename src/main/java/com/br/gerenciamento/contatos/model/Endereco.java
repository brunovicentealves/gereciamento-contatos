package com.br.gerenciamento.contatos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.br.gerenciamento.contatos.dtos.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tb_endereco")
public class Endereco {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String rua;
	
	private  Long numero;
	
	private String bairro;
	
	private String estado;
	
	private String cidade;
	
	private String cep;
	
	
	 @ManyToOne
	 @JoinColumn(name = "contato_id")
	 private Contato contato;


	public Endereco(EnderecoDTO endereco, Contato contato) {
		super();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.cep = endereco.getCep();
		this.contato = contato;
	}
	 
	 
	 

}
