package com.zappts.magicthegathering.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zappts.magicthegathering.api.dto.ListaJogadorDTO;
import com.zappts.magicthegathering.api.dto.ListaJogadorResponse;
import com.zappts.magicthegathering.domain.model.ListaJogador;
import com.zappts.magicthegathering.domain.service.ListaJogadorService;

@RestController
@RequestMapping("/jogadores")
public class ListaJogadorController {

	@Autowired
	private ListaJogadorService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{jogadorId}/listas")
	public ResponseEntity<List<ListaJogadorResponse>> getListas(
			@PathVariable Long jogadorId) {
		List<ListaJogador> listas = service.getListas(jogadorId);
		return ResponseEntity.ok(toResponseList(listas));
	}

	@GetMapping("/{jogadorId}/listas/{listaId}")
	public ResponseEntity<ListaJogadorResponse> getLista(
			@PathVariable Long jogadorId,
			@PathVariable Long listaId) {
		ListaJogador lista = service.getLista(jogadorId, listaId);
		return ResponseEntity.ok(toResponse(lista));
	}
	
	@PostMapping("/{jogadorId}/listas")
	public ResponseEntity<ListaJogadorResponse> createLista(
			@PathVariable Long jogadorId, 
			@Valid @RequestBody ListaJogadorDTO listaJogadorDTO) {
		ListaJogador request = toRequest(listaJogadorDTO);
		ListaJogador lista = service.create(jogadorId, request);
		return ResponseEntity.ok(toResponse(lista));
	}
	
	
	
	// MAPPERS
	private ListaJogador toRequest(ListaJogadorDTO createListaDTO) {
		return modelMapper.map(createListaDTO, ListaJogador.class);
	}
	
	private ListaJogadorResponse toResponse(ListaJogador lista) {
		if (lista != null) {
			// Mapeamento definido no modelmapperconfig
			return modelMapper.map(lista, ListaJogadorResponse.class);
		} else {
			return null;
		}
	}
	
	private List<ListaJogadorResponse> toResponseList(List<ListaJogador> listas) {
		// TODO tirar condições após implementar exceptions
		if (listas != null) {
			return listas.stream()
				.map(lista -> toResponse(lista))
				.collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}
}
