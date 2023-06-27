package com.br.gerenciamento.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.gerenciamento.contatos.model.Endereco;


@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {

}
