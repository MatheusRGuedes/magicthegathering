package com.zappts.magicthegathering.core.exceptions;

/*
 * Class of Exception business for the application
 * */

@SuppressWarnings("serial")
public abstract class BusinesException extends RuntimeException {

	private Codes codes;
	
	public BusinesException(final Codes codes) {
		this.codes = codes;
	}

	public Codes getCodes() {
		return codes;
	}
	
	@Override
	public String getMessage() {
		return this.codes.getMessage();
	}
	
	public enum Codes {
		JOGADOR_NOT_FOUND_EXCEPTION("Jogador not found."),
		LISTA_NOT_FOUND_EXCEPTION("Lista not found."),
		CARTA_NOT_FOUND_EXCEPTION("Carta not found."),
		CARTA_DUPLICATED_EXCEPTION("Carta is duplicated."),
		INTERNAL_SERVER_ERROR_EXCEPTION("Internal server error."),
		METHOD_ARGUMENT_NOT_VALID_EXCEPTION("Argument not valid.");
		
		private String message;
		
		private Codes(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
	}
}
