package com.br.gerenciamento.contatos.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	
	 private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;

}
