package com.br.gerenciamento.contatos.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.gerenciamento.contatos.dtos.ContatoDTO;
import com.br.gerenciamento.contatos.exception.ResourceBadRequestException;
import com.br.gerenciamento.contatos.exception.ResourceNotFoundException;
import com.br.gerenciamento.contatos.model.Contato;
import com.br.gerenciamento.contatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	private static Logger logger = LoggerFactory.getLogger(ContatoService.class);
	
	
	public String adcionarContato(ContatoDTO contato) {

		logger.info("criado Contato com essas informações:{}", contato);
		
		Contato responseContato =contatoRepository.save(new Contato(contato));
		
		logger.info("Criado com sucesso! contato:{}", contato.toString());

		return "Contato Criado com sucesso ID:"+responseContato.getId();
	}
	
	
	public ContatoDTO alterarContato(ContatoDTO contato, Long id) {

		logger.info("Alterando contato id :{} , Contatos:{}", id, contato);

		if (id == null) {
			throw new ResourceBadRequestException("Não informou id do Contato");
		}
		
		buscarPorIdContatos(id);

		Contato responseContato = contatoRepository.save(new Contato(contato, id));

		logger.info("Alterado com sucesso as informações do Contato :{}",responseContato);

		return new ContatoDTO(responseContato);

	}

	public List<ContatoDTO> buscarTodosContatos() {

		logger.info("Buscando todos Contatos");

		List<Contato> list = contatoRepository.findAll();

		logger.info("Realizado com sucesso a busca pelos contatos ");

		return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}

	public Contato buscarPorIdContatos(Long id) {

		logger.info("Buscando Contato pelo id :{}", id);

		Contato contato = contatoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não Encontrado Contato!"));

		logger.info(" Contato id :{} achado com sucesso", id);

		return contato;
	}

	public String deleteContato(Long id) {
		logger.info("deletando usuario contato id:{}", id);

		if (id == null) {
			throw new ResourceBadRequestException("Não informou id do Contato");
		}

		buscarPorIdContatos(id);

		contatoRepository.deleteById(id);

		logger.info("deletado com sucesso contato id:{}", id);
		
		return "Deletado com sucesso o contato id :"+id;
	}

}
