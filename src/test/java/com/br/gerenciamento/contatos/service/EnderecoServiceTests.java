package com.br.gerenciamento.contatos.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.br.gerenciamento.contatos.dtos.EnderecoDTO;
import com.br.gerenciamento.contatos.exception.ResourceBadRequestException;
import com.br.gerenciamento.contatos.exception.ResourceNotFoundException;
import com.br.gerenciamento.contatos.model.Endereco;
import com.br.gerenciamento.contatos.repository.EnderecoRepository;
import com.br.gerenciamento.contatos.testUtil.TestUtil;

@ExtendWith(SpringExtension.class)
public class EnderecoServiceTests {
	
	
	@InjectMocks
	private EnderecoService service;
	
	
	@Mock
	private ContatoService contatoService;
	
	
	@Mock
	private EnderecoRepository repository;
	
	
	private Long contatoId = 1L;
	
	private Long contatoIdCompleto= 3L;
	
	private Long enderecoId = 1L;
	
	private Long enderecoIdNotFound=2L;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		Mockito.when(repository.save(Mockito.any())).thenReturn(TestUtil.endereco());
		
		Mockito.when(contatoService.buscarPorIdContatos(contatoId)).thenReturn(TestUtil.contato());
		Mockito.when(contatoService.buscarPorIdContatos(contatoIdCompleto)).thenReturn(TestUtil.contatoBadRequest());
		
		Mockito.when(repository.findById(enderecoId)).thenReturn(TestUtil.enderecoOptional());
		
		Mockito.doThrow(ResourceNotFoundException.class).when(repository).findById(enderecoIdNotFound);
		
		Mockito.doNothing().when(repository).deleteById(enderecoId);
		
		Mockito.when(repository.findByContato(TestUtil.contato())).thenReturn(List.of(TestUtil.endereco()));
		
		Mockito.when(repository.findByContato(TestUtil.contatoBadRequest())).thenReturn(List.of());
	}
	
	
	@Test
	public void adcionarEnderecoSucesso() {
		
		String response =service.adcionarEndereco(TestUtil.enderecoDTO(), contatoId);
		
		assertNotNull(response);
		
		Mockito.verify(repository, times(1)).save(Mockito.any());
		
		Mockito.verify(contatoService, times(1)).buscarPorIdContatos(contatoId);
	}
	
	
	@Test
	public void buscarPorIdEnderecoSucesso() {
		
		Endereco endereco  =service.buscarPorIdEndereco(enderecoId);
		
		assertNotNull(endereco);
		
		Mockito.verify(repository, times(1)).findById(enderecoId);
	}
	
	
	@Test
	public void buscarPorIdEnderecoResourceNotFoundException() {
		

	Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.buscarPorIdEndereco(enderecoIdNotFound);
		});
		
		Mockito.verify(repository, times(1)).findById(enderecoIdNotFound);
	}
	
	
	@Test
	public void deleteEnderecoSucesso() {
		
		String response =service.deleteEndereco(enderecoId);
		
		assertNotNull(response);
		
		Mockito.verify(repository, times(1)).deleteById(enderecoId);
	}
	
	
	
	
	@Test
	public void buscarTodosEnderecosPorContatoIdSucesso() {
		
		List<EnderecoDTO> endereco  =service.buscarTodosEnderecosPorContatoId(contatoId);
		
		assertNotNull(endereco);
		
		Mockito.verify(repository, times(1)).findByContato(TestUtil.contato());
	}
	
	
	@Test
	public void buscarTodosEnderecosPorContatoIdResourceNotFoundException() {
		

	Assertions.assertThrows(ResourceBadRequestException.class, () -> {
		service.buscarTodosEnderecosPorContatoId(contatoIdCompleto);
		});
		
	}
	
	
	
	
	
	

}
