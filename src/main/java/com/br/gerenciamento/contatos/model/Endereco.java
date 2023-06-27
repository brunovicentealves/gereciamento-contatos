package com.br.gerenciamento.contatos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
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

}
