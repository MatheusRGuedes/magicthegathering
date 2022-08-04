package com.zappts.magicthegathering.api.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class JogadorDTO {

	private Long id;
	
	@Length(max = 60)
	@NotBlank
	private String nome;
	
	public JogadorDTO() {
		
	}
		
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
}
