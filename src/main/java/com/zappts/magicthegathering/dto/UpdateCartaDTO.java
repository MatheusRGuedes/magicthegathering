package com.zappts.magicthegathering.dto;

import java.math.BigDecimal;

public class UpdateCartaDTO {

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
