package com.br.gerenciamento.contatos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.gerenciamento.contatos.model.Usuario;	

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findByLogin(String login);
}
