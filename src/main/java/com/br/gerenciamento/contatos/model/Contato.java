package com.br.gerenciamento.contatos.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.br.gerenciamento.contatos.dtos.ContatoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_contato")
public class Contato {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String email;

	private String telefone;

	private LocalDate dataNascimento;
	
	
	 @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;


	public Contato(ContatoDTO contato) {
		super();
		this.nome = contato.getNome();
		this.email = contato.getEmail();
		this.telefone = contato.getTelefone();
		this.dataNascimento = contato.getDataNascimento();
	}
	
	public Contato(ContatoDTO contato,Long id) {
		super();
		this.id = id; 
		this.nome = contato.getNome();
		this.email = contato.getEmail();
		this.telefone = contato.getTelefone();
		this.dataNascimento = contato.getDataNascimento();
	}
	 
	 
	 
	 

}
