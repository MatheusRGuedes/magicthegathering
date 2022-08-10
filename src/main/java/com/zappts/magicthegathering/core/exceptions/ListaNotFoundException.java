package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class ListaNotFoundException extends BusinesException {

	public ListaNotFoundException() {
		super(Codes.LISTA_NOT_FOUND_EXCEPTION);
	}
}
