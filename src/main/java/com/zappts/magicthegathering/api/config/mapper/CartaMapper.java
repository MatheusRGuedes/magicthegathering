package com.zappts.magicthegathering.api.config.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zappts.magicthegathering.api.dto.CreateCartaDTO;
import com.zappts.magicthegathering.api.dto.UpdateCartaDTO;
import com.zappts.magicthegathering.domain.model.Carta;

public class CartaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public Carta toRequest(CreateCartaDTO createCartaDTO) {
		return modelMapper.map(createCartaDTO, Carta.class); 
	}
	public Carta toRequest(UpdateCartaDTO updateCartaDTO) {
		return modelMapper.map(updateCartaDTO, Carta.class);
	}
}
