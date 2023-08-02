package com.br.gerenciamento.contatos.dtos;


import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTokenDTO {
	
	    private Integer id ;

	    @NotEmpty(message = "Campo login Obrigatorio!")
	    private String login;

	    @NotEmpty(message = "Campo senha Obrigatorio!")
	    private String senha ;

	    private boolean admin;

}
