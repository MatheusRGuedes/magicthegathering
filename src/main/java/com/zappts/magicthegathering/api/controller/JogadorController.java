package com.zappts.magicthegathering.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.zappts.magicthegathering.api.config.mapper.JogadorMapper;
import com.zappts.magicthegathering.api.dto.JogadorDTO;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.service.JogadorService;

import io.swagger.annotations.Api;

/*
 * @Api --> correlaciona o nome para configurar detalhes do controlador no swagger;
 * */

@Api(tags = "Jogador")
@RestController
@RequestMapping("/jogadores")
public class JogadorController {

	@Autowired
	private JogadorService service;
	
	@Autowired
	private JogadorMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<JogadorDTO>> getJogadores() {
		final List<Jogador> jogadores = service.getAll();
		return ResponseEntity.ok(mapper.toResponseList(jogadores));
	}
	
	@GetMapping("/{jogadorId}")
	public ResponseEntity<JogadorDTO> getJogador(
			@PathVariable final Long jogadorId) {
		final Jogador jogador = service.findOne(jogadorId);
		return ResponseEntity.ok(mapper.toResponse(jogador));
	}
	
	@PostMapping
	public ResponseEntity<Jogador> createJogador(
			@Valid @RequestBody final JogadorDTO jogadorDTO) {
		final Jogador request = mapper.toRequest(jogadorDTO);
		final Jogador jogador = service.create(request);
		return ResponseEntity.ok(jogador);
	}
	
	@PutMapping("/{jogadorId}")
	public ResponseEntity<Jogador> updateJogador(
			@PathVariable final Long jogadorId, 
			@Valid @RequestBody final JogadorDTO jogadorDTO) {
		final Jogador request = mapper.toRequest(jogadorDTO);
		final Jogador jogador = service.update(jogadorId, request);
		return ResponseEntity.ok(jogador);
	}
	
	@DeleteMapping("/{jogadorId}")
	public ResponseEntity<List<JogadorDTO>> deleteJogador(
			@PathVariable final Long jogadorId) {
		final List<Jogador> jogadores = service.delete(jogadorId);
		return ResponseEntity.ok(mapper.toResponseList(jogadores));
	}
}
