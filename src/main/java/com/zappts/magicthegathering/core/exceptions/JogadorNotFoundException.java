package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class JogadorNotFoundException extends BusinesException {

	public JogadorNotFoundException() {
		super(Codes.JOGADOR_NOT_FOUND_EXCEPTION);
	}
}
