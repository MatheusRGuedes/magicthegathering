package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class JogadorNotFoundException extends BusinesException {

	public Long jogadorId;
	
	public JogadorNotFoundException(Long jogadorId) {
		super(Codes.JOGADOR_NOT_FOUND_EXCEPTION);
		this.jogadorId = jogadorId;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() +" For id: "+ this.jogadorId.toString();
	}
}
