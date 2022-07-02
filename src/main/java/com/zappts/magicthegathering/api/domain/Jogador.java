package com.zappts.magicthegathering.api.domain;

import java.util.List;

public class Jogador {

	private Long id;
	private String nome;
	private List<CartasJogador> listas;
	
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
	
	public List<CartasJogador> getListas() {
		return listas;
	}
	public void setListas(List<CartasJogador> listas) {
		this.listas = listas;
	}
}
