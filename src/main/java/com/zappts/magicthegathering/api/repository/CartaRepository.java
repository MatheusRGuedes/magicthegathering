package com.zappts.magicthegathering.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zappts.magicthegathering.api.domain.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long>{

	List<Carta> findByListaId(Long listaId);
	List<Carta> findByListaId(Long listaId, Sort sort);
	
	List<Carta> findByNomeAndListaId(String nome, Long listaId);
	
	boolean existsByIdAndListaId(Long id, Long listaId);
}
