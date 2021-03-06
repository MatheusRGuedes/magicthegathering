package com.zappts.magicthegathering.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zappts.magicthegathering.api.domain.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}