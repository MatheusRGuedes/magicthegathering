package com.zappts.magicthegathering.api.domain;

import java.math.BigDecimal;

public class Carta {

	private Long id;
	private String nome;
	private String edicao;
	private String idioma;
	private boolean laminada;
	private BigDecimal preco;
	private Integer quantidade;
	private CartasJogador lista;
	
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
	
	public boolean isLaminada() {
		return laminada;
	}
	public void setLaminada(boolean laminada) {
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
	
	public CartasJogador getLista() {
		return lista;
	}
	public void setLista(CartasJogador lista) {
		this.lista = lista;
	}
}
