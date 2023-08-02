package com.br.gerenciamento.contatos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredenciaisDto {

    private String login;

    private String senha ;

}
