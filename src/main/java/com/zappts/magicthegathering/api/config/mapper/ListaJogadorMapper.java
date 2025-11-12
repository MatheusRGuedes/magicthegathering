package com.zappts.magicthegathering.api.config.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.zappts.magicthegathering.api.dto.ListaJogadorDTO;
import com.zappts.magicthegathering.api.dto.ListaJogadorResponse;
import com.zappts.magicthegathering.domain.model.ListaJogador;

@Mapper(componentModel = "spring")
public interface ListaJogadorMapper {

    ListaJogador toRequest(ListaJogadorDTO createListaDTO);

    ListaJogadorResponse toResponse(ListaJogador lista);

    List<ListaJogadorResponse> toResponseList(List<ListaJogador> listas);

}
