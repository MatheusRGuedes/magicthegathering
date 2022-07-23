package com.zappts.magicthegathering.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zappts.magicthegathering.api.dto.CreateCartaDTO;
import com.zappts.magicthegathering.domain.model.Carta;

/* Por ser uma biblioteca apenas, o model mapper deve ser avisado para o spring container */

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		final ModelMapper modelMapper = new ModelMapper();
		
		//Ignora o mapeamento das propriedade id e lista do DTO para o Domain
		//modelMapper.createTypeMap(CreateCartaDTO.class, Carta.class)
		//	.addMappings(mapper -> mapper.skip(Carta::setId))
		//	.addMappings(mapper -> mapper.skip(Carta::setLista));
		
		//Valida se as propriedades combinam entre DTO e Domain
		modelMapper.validate();
		
		return modelMapper;
	}
}
