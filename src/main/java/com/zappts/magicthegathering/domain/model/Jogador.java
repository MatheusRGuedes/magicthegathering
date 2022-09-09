package com.zappts.magicthegathering.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Jogador - Response")
@Table(name = "jogadores")
@Entity
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "jogador", cascade = CascadeType.REMOVE)
	private List<ListaJogador> listas;
	
	
	public Jogador() {}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<ListaJogador> getListas() {
		return listas;
	}
	public void setListas(List<ListaJogador> listas) {
		this.listas = listas;
	}
}
