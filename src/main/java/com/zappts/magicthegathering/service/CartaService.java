package com.zappts.magicthegathering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.api.domain.Carta;
import com.zappts.magicthegathering.api.repository.CartaRepository;
import com.zappts.magicthegathering.api.repository.JogadorRepository;

@Service
public class CartaService {

	@Autowired
	private CartaRepository repository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public List<Carta> getCartas(Long jogadorId, Long listaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		final List<Carta> listaCartas = repository.findByListaId(listaId);
		return listaCartas;
		//listaCartas.stream().map(carta -> carta.getLista().getJogador().setId(jogadorId));
	}
	
	public Carta getCarta(Long jogadorId, Long cartaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			return null;
		}
		
		if (!repository.existsById(cartaId)) {
			return null;
		}
		
		Carta carta = repository.findById(cartaId).orElse(null);
		return carta;
	}
}

