package com.zappts.magicthegathering.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;

public class UpdateCartaDTO {

	@Digits(integer = 4, fraction = 2)
	private BigDecimal valor;
	private Integer quantidade;
	
	
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
