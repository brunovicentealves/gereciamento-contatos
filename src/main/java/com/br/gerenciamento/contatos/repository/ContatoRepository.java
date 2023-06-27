package com.br.gerenciamento.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.gerenciamento.contatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
