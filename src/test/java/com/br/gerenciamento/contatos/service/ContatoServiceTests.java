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
import com.br.gerenciamento.contatos.dtos.ContatoDTO;
import com.br.gerenciamento.contatos.exception.ResourceBadRequestException;
import com.br.gerenciamento.contatos.exception.ResourceNotFoundException;
import com.br.gerenciamento.contatos.model.Contato;
import com.br.gerenciamento.contatos.repository.ContatoRepository;
import com.br.gerenciamento.contatos.testUtil.TestUtil;


@ExtendWith(SpringExtension.class)
public class ContatoServiceTests {
	
	@InjectMocks
	private ContatoService service;
	
	
	@Mock
	private ContatoRepository repository;
	
	private Long idContatoNotfound = 2L;
	private Long idContato= 1L;
	private Long idContratoComEndereco=3L; 
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		Mockito.when(repository.save(Mockito.any())).thenReturn(TestUtil.contato());
		Mockito.when(repository.findAll()).thenReturn(List.of(TestUtil.contato()));
		
		Mockito.when(repository.findById(1L)).thenReturn(TestUtil.contatoOptional());
		
		Mockito.when(repository.findById(3L)).thenReturn(TestUtil.contatoOptionalCompleto());
		
		Mockito.doThrow(ResourceNotFoundException.class).when(repository).findById(idContatoNotfound);
		
		Mockito.doNothing().when(repository).deleteById(idContato);
		Mockito.doNothing().when(repository).deleteById(idContratoComEndereco);
		
	}
	
	
	@Test
	public void adcionarContatoSucesso() {
		
		String response =service.adcionarContato(TestUtil.contatoDTO());
		
		assertNotNull(response);
		
		Mockito.verify(repository, times(1)).save(Mockito.any());
	}
	
	
	@Test
	public void buscarTodosContatoSucesso() {
		
		List<ContatoDTO> list =service.buscarTodosContatos();
		
		assertNotNull(list);
		
		Mockito.verify(repository, times(1)).findAll();
	}
	
	
	@Test
	public void buscarPorIdContatosSucesso() {
		
		Contato contato =service.buscarPorIdContatos(1L);
		
		assertNotNull(contato);
		
		Mockito.verify(repository, times(1)).findById(1L);
	}
	
	
	@Test
	public void buscarPorIdContatosResourceNotFoundException() {
		

	Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.buscarPorIdContatos(idContatoNotfound);
		});
		
		Mockito.verify(repository, times(1)).findById(idContatoNotfound);
	}
	
	

	@Test
	public void deleteContatoSucesso() {
		
		String response =service.deleteContato(idContato);
		
		assertNotNull(response);
		
		Mockito.verify(repository, times(1)).deleteById(idContato);
	}
	
	
	@Test
	public void deleteContatoResourceBadRequestException() {
		
		Assertions.assertThrows(ResourceBadRequestException.class, () -> {
			service.deleteContato(idContratoComEndereco);
		});
		
	}
	
	
	@Test
	public void alterarContatoSucesso() {
		
		ContatoDTO response =service.alterarContato(TestUtil.contatoDTO(), idContato);
		
		assertNotNull(response);
		
		Mockito.verify(repository, times(1)).save(Mockito.any());
	
		Mockito.verify(repository, times(1)).findById(1L);
		
	}
	
	
	
	

}
