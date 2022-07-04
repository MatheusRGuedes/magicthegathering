package com.zappts.magicthegathering.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zappts.magicthegathering.api.domain.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long>{

}
