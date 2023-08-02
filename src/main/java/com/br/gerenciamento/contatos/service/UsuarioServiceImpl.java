package com.br.gerenciamento.contatos.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.br.gerenciamento.contatos.dtos.UsuarioTokenDTO;
import com.br.gerenciamento.contatos.exception.SenhaInvalidaException;
import com.br.gerenciamento.contatos.model.Usuario;
import com.br.gerenciamento.contatos.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
  
    @Transactional
    public Usuario salvar (UsuarioTokenDTO usuario){
    	
    	 String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
 
         usuario.setSenha(senhaCriptografada);
    	 
      return  usuarioRepository.save(Usuario.builder().login(usuario.getLogin()).senha(usuario.getSenha()).admin(usuario.isAdmin()).build());
    }

    public UserDetails autenticarUsuario(Usuario usuario){
        UserDetails user = loadUserByUsername(usuario.getLogin());
       boolean senhasBatem =  passwordEncoder.matches(usuario.getSenha(),user.getPassword());

               if(senhasBatem){
                   return user;
        }
        throw  new SenhaInvalidaException("login ou senha invalida!");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usuario =  usuarioRepository.findByLogin(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

      String [] roles  = usuario.isAdmin() ? new String[]{"ADMIN","USER"} : new String[] {"USER"};

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }

}
