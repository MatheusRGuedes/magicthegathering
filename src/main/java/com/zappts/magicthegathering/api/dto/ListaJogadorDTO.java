package com.zappts.magicthegathering.api.dto;

import javax.validation.constraints.NotBlank;

public class ListaJogadorDTO {
	
	@NotBlank
	private String nome;

	public ListaJogadorDTO() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
