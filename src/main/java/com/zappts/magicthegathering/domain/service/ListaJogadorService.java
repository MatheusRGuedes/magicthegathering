package com.zappts.magicthegathering.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.model.ListaJogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;
import com.zappts.magicthegathering.domain.repository.ListaJogadorRepository;

//#TODO trocar retorno nulo por exceptions

@Service
public class ListaJogadorService {

	@Autowired
	private ListaJogadorRepository repository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public List<ListaJogador> getListas(Long jogadorId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
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
			return null;
		}
		
		if (!repository.existsById(listaId)) {
			return null;
		}
		
		return repository.findById(listaId).get();
	}
	
	public ListaJogador create(Long jogadorId, ListaJogador request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		Jogador jogador = jogadorRepository.findById(jogadorId).get();
		request.setJogador(jogador);
		
		return repository.save(request);
	}
	
	public ListaJogador update(Long jogadorId, Long listaId, ListaJogador request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		if (!repository.existsById(listaId)) {
			return null;
		}
		
		Jogador jogador = jogadorRepository.findById(jogadorId).get();
		
		request.setId(listaId);
		request.setJogador(jogador);
		
		return repository.save(request);
	}
	
	public List<ListaJogador> delete(Long jogadorId, Long listaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		if (!repository.existsById(listaId)) {
			return null;
		}
		
		repository.deleteById(listaId);
		
		return repository.findAllByJogadorId(jogadorId);
	}
}
