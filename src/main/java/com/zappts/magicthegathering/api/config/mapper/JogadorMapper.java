package com.zappts.magicthegathering.api.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.zappts.magicthegathering.api.dto.JogadorDTO;
import com.zappts.magicthegathering.domain.model.Jogador;

//irá gerar automaticamente uma implementação (JogadorMapperImpl) durante a compilação,

@Mapper(componentModel = "spring")
public interface JogadorMapper {

    Jogador toRequest(JogadorDTO jogadorDTO);

    JogadorDTO toResponse(Jogador jogador);

    List<JogadorDTO> toResponseList(List<Jogador> jogadores);
}
