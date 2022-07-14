package com.zappts.magicthegathering.api.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "lista_jogadores")
@Entity
public class ListaJogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 256)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

	@JsonManagedReference
	@OneToMany(mappedBy = "lista")
	private List<Carta> cartas;
	
	
	public ListaJogador() {
		
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
