package com.zappts.magicthegathering.api.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ListaJogadorDTO {
	
	@Length(max = 60)
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
