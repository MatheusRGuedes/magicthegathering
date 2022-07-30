package com.zappts.magicthegathering.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.magicthegathering.domain.model.ListaJogador;

public interface ListaJogadorRepository extends JpaRepository<ListaJogador, Long> {

	List<ListaJogador> findAllByJogadorId(Long jogadorId);
}
