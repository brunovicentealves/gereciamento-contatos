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

		logger.info("Criando Contato com essas informações:{}", contato.toString());
		
		Contato responseContato =contatoRepository.save(new Contato(contato));
		
		logger.info("Criado com sucesso! contato:{}", contato.toString());

		return "Contato Criado com sucesso ID:"+responseContato.getId();
	}
	
	
	public ContatoDTO alterarContato(ContatoDTO contato, Long id) {

		logger.info("Alterando contato id :{} , Contatos:{}", id, contato);

		validaIdContatoNull(id);
		
		buscarPorIdContatos(id);

		Contato responseContato = contatoRepository.save(new Contato(contato, id));

		logger.info("Alterado com sucesso as informações do Contato :{}",responseContato.toString());

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
		logger.info("Deletando Contato id:{}", id);

		validaIdContatoNull(id);

		Contato contato = buscarPorIdContatos(id);
		
		validaEnderecoVinculado(contato);
		
		contatoRepository.deleteById(id);

		logger.info("Deletado com sucesso Contato id:{}", id);
		
		return "Deletado com sucesso o contato id :"+id;
	}


	private void validaIdContatoNull(Long id) {
		if (id == null) {
			throw new ResourceBadRequestException("Não informou id do Contato");
		}
	}


	private void validaEnderecoVinculado(Contato contato) {
		if(!contato.getEnderecos().isEmpty()) {
			throw new ResourceBadRequestException("Não pode excluir contato , pois tem Endereços vinculados !");
		}
	}

}
