package com.zappts.magicthegathering.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.magicthegathering.api.domain.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}