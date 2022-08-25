package com.zappts.magicthegathering.api.config.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zappts.magicthegathering.api.dto.JogadorDTO;
import com.zappts.magicthegathering.domain.model.Jogador;

public class JogadorMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Jogador toRequest(JogadorDTO jogadorDTO) {
		return modelMapper.map(jogadorDTO, Jogador.class);
	}
	
	// TODO retirar condição ao add exceções no service
	public JogadorDTO toResponse(Jogador jogador) {
		return modelMapper.map(jogador, JogadorDTO.class);
	}
	
	public List<JogadorDTO> toResponseList(List<Jogador> jogadores) {
		return jogadores.stream()
				.map(jogador -> toResponse(jogador))
				.collect(Collectors.toList());
	}
}
