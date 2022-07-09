package com.zappts.magicthegathering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.magicthegathering.api.domain.Carta;
import com.zappts.magicthegathering.service.CartaService;

@RestController
@RequestMapping("/jogadores")
public class CartaController {

	@Autowired
	private CartaService service;
	
	@GetMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<List<Carta>> getCartas(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId) {
		final List<Carta> cartas = service.getCartas(jogadorId, listaId);
		return ResponseEntity.ok(cartas);
	}
	
	@PostMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<Carta> createCarta(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId,
			@RequestBody Carta request) {
		final Carta carta = service.create(jogadorId, listaId, request);
		return ResponseEntity.ok(carta);
	}
}
