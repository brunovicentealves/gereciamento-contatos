package com.br.gerenciamento.contatos.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.gerenciamento.contatos.dtos.EnderecoDTO;
import com.br.gerenciamento.contatos.exception.ResourceBadRequestException;
import com.br.gerenciamento.contatos.exception.ResourceNotFoundException;
import com.br.gerenciamento.contatos.model.Contato;
import com.br.gerenciamento.contatos.model.Endereco;
import com.br.gerenciamento.contatos.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContatoService service;

	private static Logger logger = LoggerFactory.getLogger(EnderecoService.class);

	public String adcionarEndereco(@Valid EnderecoDTO endereco, Long contatoId) {

		Contato contato = service.buscarPorIdContatos(contatoId);

		Endereco responseEndereco = enderecoRepository.save(new Endereco(endereco, contato));

		return "Endereco Criado com sucesso ID:" + responseEndereco.getId();
	}

	public List<EnderecoDTO> buscarTodosEnderecosPorContatoId(Long contatoId) {
		
		Contato contato =service.buscarPorIdContatos(contatoId);
		
		List<Endereco> endereco = enderecoRepository.findByContato(contato);
		
		if(endereco.isEmpty()) {
			throw new ResourceBadRequestException("Não tem endereços cadastrados para Contato id:"+contatoId);	
		}
		
		return endereco.stream().map(x-> new EnderecoDTO(x)).collect(Collectors.toList());
	}
	
	
	public Endereco buscarPorIdEndereco(Long id) {

		logger.info("Buscando Endereco pelo id :{}", id);

		Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não Encontrado Contato!"));

		logger.info(" Endereco id :{} achado com sucesso", id);

		return endereco;
	}


	public String deleteContato(Long enderecoId) {
		
		logger.info("deletando  Endereco id:{}", enderecoId);
		
		if (enderecoId == null) {
			throw new ResourceBadRequestException("Não informou id do Endereco");
		}
		
		 buscarPorIdEndereco(enderecoId);
		
		enderecoRepository.deleteById(enderecoId);
		
		logger.info("Deletado com sucesso Endereco id:{}", enderecoId);
		
		
		return "Deletado com sucesso o Endereco id :"+enderecoId;
	}

}
