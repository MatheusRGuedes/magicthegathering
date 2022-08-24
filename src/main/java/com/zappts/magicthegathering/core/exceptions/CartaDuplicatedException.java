package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class CartaDuplicatedException extends BusinesException {

	public CartaDuplicatedException() {
		super(Codes.CARTA_DUPLICATED_EXCEPTION);
	}
}
