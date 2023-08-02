package com.br.gerenciamento.contatos.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.br.gerenciamento.contatos.config.JwtService;
import com.br.gerenciamento.contatos.dtos.CredenciaisDto;
import com.br.gerenciamento.contatos.dtos.TokenDTO;
import com.br.gerenciamento.contatos.dtos.UsuarioTokenDTO;
import com.br.gerenciamento.contatos.exception.SenhaInvalidaException;
import com.br.gerenciamento.contatos.model.Usuario;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenController {


    private  final com.br.gerenciamento.contatos.service.UsuarioServiceImpl usuarioService;
    private final JwtService jwtService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid  UsuarioTokenDTO usuario){
      
         return usuarioService.salvar(usuario);
    }

    @PostMapping("/jwt")
    public TokenDTO autenticarUsuario ( @RequestBody  CredenciaisDto credenciaisDto){
    try {

       Usuario usuario = Usuario.builder().
                login(credenciaisDto.getLogin())
                .senha(credenciaisDto.getSenha())
                .build();

       UserDetails userDetails =  usuarioService.autenticarUsuario(usuario);

      String token= jwtService.gerartoken(usuario);

       return  new TokenDTO(usuario.getLogin(),token);

        }catch (UsernameNotFoundException | SenhaInvalidaException e ){
        throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());

          }
    }
    
}