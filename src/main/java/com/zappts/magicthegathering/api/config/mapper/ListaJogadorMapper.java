package com.zappts.magicthegathering.api.config.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zappts.magicthegathering.api.dto.ListaJogadorDTO;
import com.zappts.magicthegathering.api.dto.ListaJogadorResponse;
import com.zappts.magicthegathering.domain.model.ListaJogador;

public class ListaJogadorMapper {

	@Autowired
	private ModelMapper modelMapper;
	

	// MODEL MAPPERS
	public ListaJogador toRequest(ListaJogadorDTO createListaDTO) {
		return modelMapper.map(createListaDTO, ListaJogador.class);
	}
	
	public ListaJogadorResponse toResponse(ListaJogador lista) {
		// Mapeamento definido no modelmapperconfig
		return modelMapper.map(lista, ListaJogadorResponse.class);
	}
	
	public List<ListaJogadorResponse> toResponseList(List<ListaJogador> listas) {
		return listas.stream()
				.map(lista -> toResponse(lista))
				.collect(Collectors.toList());
	}
}
