package com.zappts.magicthegathering.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.core.exceptions.JogadorNotFoundException;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repository;
	
	public List<Jogador> getAll() {
		return repository.findAll();
	}
	
	public Jogador findOne(Long id) {
		
		if (!repository.existsById(id)) {
			throw new JogadorNotFoundException();
		}
		
		Optional<Jogador> jogador = repository.findById(id);
		return jogador.get();
	}
	
	public Jogador create(Jogador jogador) {
		return repository.save(jogador);
	}
	
	public Jogador update(Long id, Jogador request) {
		
		if (!repository.existsById(id)) {
			throw new JogadorNotFoundException();
		}
		
		request.setId(id);
		
		return repository.save(request);
	}
	
	public List<Jogador> delete(Long id) {
		
		if (!repository.existsById(id)) {
			throw new JogadorNotFoundException();
		}
		
		repository.deleteById(id);
		
		return getAll();
	}
}
