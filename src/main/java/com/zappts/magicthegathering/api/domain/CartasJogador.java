package com.zappts.magicthegathering.api.domain;

import java.util.List;

public class CartasJogador {
	
	private Long id;
	private Jogador jogador;
	private List<Carta> cartas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}
	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
}
