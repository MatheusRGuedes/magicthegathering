package com.zappts.magicthegathering.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zappts.magicthegathering.api.enums.Idioma;

public class CreateCartaDTO {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String edicao;
	@NotNull
	private Idioma idioma;
	@NotBlank
	private String laminada;
	private BigDecimal valor;
	private Integer quantidade;
	
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
	
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public String getLaminada() {
		return laminada;
	}
	public void setLaminada(String laminada) {
		this.laminada = laminada;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
