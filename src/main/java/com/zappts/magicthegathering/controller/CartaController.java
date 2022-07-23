package com.zappts.magicthegathering.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.magicthegathering.api.domain.Carta;
import com.zappts.magicthegathering.dto.CreateCartaDTO;
import com.zappts.magicthegathering.dto.UpdateCartaDTO;
import com.zappts.magicthegathering.service.CartaService;

@RestController
@RequestMapping("/jogadores")
public class CartaController {

	@Autowired
	private CartaService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<List<Carta>> getCartas(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId,
			@RequestParam Optional<String> order) {
		final List<Carta> cartas = service.getCartas(jogadorId, listaId, order);
		return ResponseEntity.ok(cartas);
	}
	
	@GetMapping("/{jogadorId}/listas/{listaId}/cartas/{cartaId}")
	public ResponseEntity<Carta> getCarta(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId,
			@PathVariable Long cartaId) {
		final Carta carta = service.getCarta(jogadorId, listaId, cartaId);
		return ResponseEntity.ok(carta);
	}
	
	@PostMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<Carta> createCarta(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId,
			@Valid @RequestBody final CreateCartaDTO createCartaDTO) {
		final Carta request = toRequest(createCartaDTO);
		final Carta carta = service.create(jogadorId, listaId, request);
		return ResponseEntity.ok(carta);
	}
	
	@PatchMapping("/{jogadorId}/listas/{listaId}/cartas/{cartaId}")
	public ResponseEntity<Carta> updateCarta(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId,
			@PathVariable Long cartaId,
			@RequestBody UpdateCartaDTO updateCartaDTO) {
		final Carta request = toRequest(updateCartaDTO);
		final Carta carta = service.update(jogadorId, listaId, cartaId, request);
		return ResponseEntity.ok(carta);
	}
	
	@DeleteMapping("/{jogadorId}/listas/{listaId}/cartas/{cartaId}")
	public ResponseEntity<List<Carta>> deleteCarta(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId,
			@PathVariable Long cartaId) {
		final List<Carta> cartas = service.delete(jogadorId, listaId, cartaId);
		return ResponseEntity.ok(cartas);
	}
	
	// Model Mapper
	private Carta toRequest(CreateCartaDTO createCartaDTO) {
		return modelMapper.map(createCartaDTO, Carta.class); 
	}
	private Carta toRequest(UpdateCartaDTO updateCartaDTO) {
		return modelMapper.map(updateCartaDTO, Carta.class);
	}
}
