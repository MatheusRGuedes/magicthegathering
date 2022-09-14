package com.zappts.magicthegathering.api.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Jogador - Request")
public class JogadorDTO {

	private Long id;
	
	@Length(max = 60)
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public JogadorDTO() {
		
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
