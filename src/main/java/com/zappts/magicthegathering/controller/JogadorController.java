package com.zappts.magicthegathering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.magicthegathering.api.domain.Jogador;
import com.zappts.magicthegathering.service.JogadorService;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

	@Autowired
	private JogadorService service;
	
	@GetMapping
	public ResponseEntity<List<Jogador>> getJogadores() {
		final List<Jogador> jogadores = service.getAll();
		return ResponseEntity.ok(jogadores);
	}
	
	@GetMapping(path = "/{jogadorId}")
	public ResponseEntity<Jogador> getJogador(@PathVariable final Long jogadorId) {
		final Jogador jogador = service.findOne(jogadorId);
		return ResponseEntity.ok(jogador);
	}
	
	@PostMapping
	public ResponseEntity<Jogador> createJogador(@RequestBody final Jogador request) {
		final Jogador jogador = service.create(request);
		return ResponseEntity.ok(jogador);
	}
	
	@PutMapping(path = "/{jogadorId}")
	public ResponseEntity<Jogador> updateJogador(
			@PathVariable final Long jogadorId, 
			@RequestBody final Jogador request) {
		final Jogador jogador = service.update(jogadorId, request);
		return ResponseEntity.ok(jogador);
	}
	
	@DeleteMapping(path = "/{jogadorId}")
	public ResponseEntity<List<Jogador>> deleteJogador(@PathVariable Long jogadorId) {
		final List<Jogador> jogadores = service.delete(jogadorId);
		return ResponseEntity.ok(jogadores);
	}
}
