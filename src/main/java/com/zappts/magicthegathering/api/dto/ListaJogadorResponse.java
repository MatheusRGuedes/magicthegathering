package com.zappts.magicthegathering.api.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Lista Jogador - Response")
public class ListaJogadorResponse {

	private Long id;
	private String nome;
	private String jogador;
	
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
	
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	
}
