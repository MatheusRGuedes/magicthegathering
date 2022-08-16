package com.zappts.magicthegathering.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.core.exceptions.JogadorNotFoundException;
import com.zappts.magicthegathering.core.exceptions.ListaNotFoundException;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.model.ListaJogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;
import com.zappts.magicthegathering.domain.repository.ListaJogadorRepository;

@Service
public class ListaJogadorService {

	@Autowired
	private ListaJogadorRepository repository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public List<ListaJogador> getListas(Long jogadorId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException(jogadorId);
		}
		
		List<ListaJogador> listas = repository.findAllByJogadorId(jogadorId);
		if (listas.isEmpty()) {
			return new ArrayList<ListaJogador>();
		} else {
			return listas;
		}
	}
	
	public ListaJogador getLista(Long jogadorId, Long listaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException(jogadorId);
		}
		
		if (!repository.existsById(listaId)) {
			throw new ListaNotFoundException(listaId);
		}
		
		return repository.findById(listaId).get();
	}
	
	public ListaJogador create(Long jogadorId, ListaJogador request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException(jogadorId);
		}
		
		Jogador jogador = jogadorRepository.findById(jogadorId).get();
		request.setJogador(jogador);
		
		return repository.save(request);
	}
	
	public ListaJogador update(Long jogadorId, Long listaId, ListaJogador request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException(jogadorId);
		}
		
		if (!repository.existsById(listaId)) {
			throw new ListaNotFoundException(listaId);
		}
		
		Jogador jogador = jogadorRepository.findById(jogadorId).get();
		
		request.setId(listaId);
		request.setJogador(jogador);
		
		return repository.save(request);
	}
	
	public List<ListaJogador> delete(Long jogadorId, Long listaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException(jogadorId);
		}
		
		if (!repository.existsById(listaId)) {
			throw new ListaNotFoundException(listaId);
		}
		
		repository.deleteById(listaId);
		
		return repository.findAllByJogadorId(jogadorId);
	}
}
