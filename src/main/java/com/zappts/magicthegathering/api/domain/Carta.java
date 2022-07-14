package com.zappts.magicthegathering.api.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "cartas")
@Entity
public class Carta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 256)
	private String nome;
	
	@Column(nullable = false)
	private String edicao;
	
	@Column(nullable = false)
	private String idioma;
	
	private String laminada;
	
	@Column(columnDefinition = "decimal", precision = 6, scale = 2)
	private BigDecimal preco;
	private Integer quantidade;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "lista_jogador_id")
	private ListaJogador lista;
	
	
	public Carta() {
		
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
	
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getLaminada() {
		return laminada;
	}
	public void setLaminada(String laminada) {
		this.laminada = laminada;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public ListaJogador getLista() {
		return lista;
	}
	public void setLista(ListaJogador lista) {
		this.lista = lista;
	}
}
