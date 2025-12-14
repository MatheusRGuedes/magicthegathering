package com.zappts.magicthegathering.api.config.mapper;

import org.mapstruct.Mapper;

import com.zappts.magicthegathering.api.dto.CreateCartaDTO;
import com.zappts.magicthegathering.api.dto.UpdateCartaDTO;
import com.zappts.magicthegathering.domain.model.Carta;

@Mapper(componentModel = "spring")
public interface CartaMapper {

    Carta toRequest(CreateCartaDTO createCartaDTO);

    Carta toRequest(UpdateCartaDTO updateCartaDTO);
}
