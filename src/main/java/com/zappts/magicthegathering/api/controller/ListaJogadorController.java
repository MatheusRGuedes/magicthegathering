package com.zappts.magicthegathering.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.magicthegathering.api.config.mapper.ListaJogadorMapper;
import com.zappts.magicthegathering.api.dto.ListaJogadorDTO;
import com.zappts.magicthegathering.api.dto.ListaJogadorResponse;
import com.zappts.magicthegathering.domain.model.ListaJogador;
import com.zappts.magicthegathering.domain.service.ListaJogadorService;

import io.swagger.annotations.Api;

@Api(tags = "Lista Jogador")
@RestController
@RequestMapping("/jogadores")
public class ListaJogadorController {

	@Autowired
	private ListaJogadorService service;
	
	@Autowired
	private ListaJogadorMapper mapper;

	@GetMapping("/{jogadorId}/listas")
	public ResponseEntity<List<ListaJogadorResponse>> getListas(
			@PathVariable Long jogadorId) {
		List<ListaJogador> listas = service.getListas(jogadorId);
		return ResponseEntity.ok(mapper.toResponseList(listas));
	}

	@GetMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<ListaJogadorResponse> getLista(
			@PathVariable Long jogadorId,
			@PathVariable Long listaId) {
		ListaJogador lista = service.getLista(jogadorId, listaId);
		return ResponseEntity.ok(mapper.toResponse(lista));
	}
	
	@PostMapping("/{jogadorId}/listas")
	public ResponseEntity<ListaJogadorResponse> createLista(
			@PathVariable Long jogadorId, 
			@Valid @RequestBody ListaJogadorDTO listaJogadorDTO) {
		ListaJogador request = mapper.toRequest(listaJogadorDTO);
		ListaJogador lista = service.create(jogadorId, request);
		return ResponseEntity.ok(mapper.toResponse(lista));
	}
	
	@PatchMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<ListaJogadorResponse> updateLista(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId, 
			@Valid @RequestBody ListaJogadorDTO listaJogadorDTO) {
		ListaJogador request = mapper.toRequest(listaJogadorDTO);
		ListaJogador lista = service.update(jogadorId, listaId, request);
		return ResponseEntity.ok(mapper.toResponse(lista));
	}
	
	@DeleteMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<List<ListaJogadorResponse>> deleteLista(
			@PathVariable Long jogadorId, 
			@PathVariable Long listaId) {
		List<ListaJogador> listas = service.delete(jogadorId, listaId);
		return ResponseEntity.ok(mapper.toResponseList(listas));
	}
}
