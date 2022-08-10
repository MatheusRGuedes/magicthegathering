package com.zappts.magicthegathering.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.core.exceptions.CartaNotFoundException;
import com.zappts.magicthegathering.core.exceptions.JogadorNotFoundException;
import com.zappts.magicthegathering.core.exceptions.ListaNotFoundException;
import com.zappts.magicthegathering.domain.model.Carta;
import com.zappts.magicthegathering.domain.model.ListaJogador;
import com.zappts.magicthegathering.domain.repository.CartaRepository;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;
import com.zappts.magicthegathering.domain.repository.ListaJogadorRepository;

@Service
public class CartaService {

	@Autowired
	private CartaRepository repository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private ListaJogadorRepository listaJogadorRepository;
	
	public List<Carta> getCartas(Long jogadorId, Long listaId, Optional<String> orderParam) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException();
		}
		
		if (!listaJogadorRepository.existsById(listaId)) {
			throw new ListaNotFoundException();
		}
		
		List<Carta> listaCartas = new ArrayList<>();
		
		if (orderParam.isPresent()) {
			listaCartas = getCartasSorted(listaId, orderParam.get());
		} else {
			listaCartas = repository.findByListaId(listaId);
		}
		
		return listaCartas;
	}
	
	public Carta getCarta(Long jogadorId, Long listaId, Long cartaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException();
		}
		
		if (!repository.existsByIdAndListaId(cartaId, listaId)) {
			throw new CartaNotFoundException();
		}
		
		final Carta carta = repository.findById(cartaId).get();
		return carta;
	}
	
	public Carta create(Long jogadorId, Long listaId, Carta request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException();
		}
		
		if (!listaJogadorRepository.existsById(listaId)) {
			throw new ListaNotFoundException();
		}
		
		if (isCartaRepeated(request, listaId)) {
			return null;
		}
		
		final ListaJogador lista = listaJogadorRepository.findById(listaId).get();
		request.setLista(lista);
		
		return repository.save(request);
	}

	public Carta update(Long jogadorId, Long listaId, Long cartaId, Carta request) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException();
		}
		
		if (!repository.existsByIdAndListaId(cartaId, listaId)) {
			throw new CartaNotFoundException();
		}
		
		//final CartasJogador lista = cartasJogadorRepository.findById(listaId).get();
		final Carta carta = repository.findById(cartaId).get();
		carta.setValor(request.getValor());
		carta.setQuantidade(request.getQuantidade());
		
		return repository.save(carta);
	}
	
	public List<Carta> delete(Long jogadorId, Long listaId, Long cartaId) {
		
		if (!jogadorRepository.existsById(jogadorId)) {
			throw new JogadorNotFoundException();
		}
		
		if (!repository.existsByIdAndListaId(cartaId, listaId)) {
			throw new CartaNotFoundException();
		}
		
		repository.deleteById(cartaId);
		
		final List<Carta> cartas = repository.findByListaId(listaId);
		return cartas;
	}
	
	// Get Cartas Ordered
	private List<Carta> getCartasSorted(Long listaId, String order) {
		if ("nome".equalsIgnoreCase(order) || "valor".equalsIgnoreCase(order)) {
			return repository.findByListaId(listaId, Sort.by(Direction.ASC, order));
		}
		return repository.findByListaId(listaId);
	}
	
	private boolean isCartaRepeated(Carta request, Long listaId) {
		List<Carta> cartas = repository.findByNomeAndListaId(request.getNome(), listaId);
		List<Carta> duplicadas = cartas.stream()
				.filter(carta -> carta.equals(request))
				.collect(Collectors.toList());
		return !duplicadas.isEmpty();
	}
}

