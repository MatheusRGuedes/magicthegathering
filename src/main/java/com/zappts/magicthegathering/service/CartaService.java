package com.zappts.magicthegathering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.api.domain.Carta;
import com.zappts.magicthegathering.api.domain.CartasJogador;
import com.zappts.magicthegathering.api.repository.CartaRepository;
import com.zappts.magicthegathering.api.repository.CartasJogadorRepository;
import com.zappts.magicthegathering.api.repository.JogadorRepository;

@Service
public class CartaService {

	@Autowired
	private CartaRepository repository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private CartasJogadorRepository cartasJogadorRepository;
	
	public List<Carta> getCartas(Long jogadorId, Long listaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		final List<Carta> listaCartas = repository.findByListaId(listaId);
		return listaCartas;
	}
	
	public Carta getCarta(Long jogadorId, Long listaId, Long cartaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		if (!repository.existsByIdAndListaId(cartaId, listaId)) {
			return null;
		}
		
		final Carta carta = repository.findById(cartaId).orElse(null);
		return carta;
	}
	
	public Carta create(Long jogadorId, Long listaId, Carta request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		if (!cartasJogadorRepository.existsById(listaId)) {
			return null;
		}
		
		final CartasJogador lista = cartasJogadorRepository.findById(listaId).get();
		request.setLista(lista);
		
		return repository.save(request);
	}
	
	public Carta update(Long listaId, Long cartaId, Carta request) {
		
		if (!repository.existsByIdAndListaId(cartaId, listaId)) {
			return null;
		}
		
		//final CartasJogador lista = cartasJogadorRepository.findById(listaId).get();
		final Carta carta = repository.findById(cartaId).get();
		carta.setPreco(request.getPreco());
		carta.setQuantidade(request.getQuantidade());
		
		return repository.save(carta);
	}
	
	public List<Carta> delete(Long listaId, Long cartaId) {
		
		if (!repository.existsByIdAndListaId(cartaId, listaId)) {
			return null;
		}
		
		repository.deleteById(cartaId);
		
		final List<Carta> cartas = repository.findAll();
		return cartas;
	}
}

