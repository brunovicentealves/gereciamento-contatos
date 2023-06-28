package com.br.gerenciamento.contatos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.gerenciamento.contatos.model.Contato;
import com.br.gerenciamento.contatos.model.Endereco;


@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {

	List<Endereco> findByContato(Contato contato);

}
