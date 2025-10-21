package com.zappts.magicthegathering.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zappts.magicthegathering.domain.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

	Optional<Jogador> findByUsername(String username); 
}