package com.zappts.magicthegathering.api.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "jogadores")
@Entity
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 256)
	private String nome;
	
	@OneToMany(mappedBy = "jogador")
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
