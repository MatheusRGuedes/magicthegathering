package com.zappts.magicthegathering.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.zappts.magicthegathering.domain.enums.Idioma;

public class CreateCartaDTO {
	
	@NotBlank
	@Length(max = 60)
	private String nome;
	@NotBlank
	@Length(max = 60)
	private String edicao;
	@NotNull
	private Idioma idioma;
	@NotNull
	private Boolean laminada;
	@Digits(integer = 4, fraction = 2)
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
	
	public Boolean getLaminada() {
		return laminada;
	}
	public void setLaminada(Boolean laminada) {
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
