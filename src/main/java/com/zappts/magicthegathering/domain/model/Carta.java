package com.zappts.magicthegathering.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zappts.magicthegathering.domain.enums.Idioma;

/*
 * Boolean no MySql é convertido para integer 0-false ou 1-true
 * */

@Table(name = "cartas")
@Entity
public class Carta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Column(nullable = false, length = 60)
	private String edicao;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Idioma idioma;
	
	@Column(nullable = false)
	private Boolean laminada;
	
	@Column(columnDefinition = "Decimal", precision = 6, scale = 2)
	private BigDecimal valor;
	
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
	
	public ListaJogador getLista() {
		return lista;
	}
	public void setLista(ListaJogador lista) {
		this.lista = lista;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (edicao == null) {
			if (other.edicao != null)
				return false;
		} else if (!edicao.equals(other.edicao))
			return false;
		if (idioma != other.idioma)
			return false;
		if (laminada == null) {
			if (other.laminada != null)
				return false;
		} else if (!laminada.equals(other.laminada))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
