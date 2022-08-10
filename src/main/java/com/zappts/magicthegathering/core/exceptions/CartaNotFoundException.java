package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class CartaNotFoundException extends BusinesException {

	public CartaNotFoundException() {
		super(Codes.CARTA_NOT_FOUND_EXCEPTION);
	}
}
