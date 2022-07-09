package com.zappts.magicthegathering.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.magicthegathering.api.domain.ListaJogador;

public interface CartasJogadorRepository extends JpaRepository<ListaJogador, Long> {

}
