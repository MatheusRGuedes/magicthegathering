package com.zappts.magicthegathering.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Class of Exception business for the application
 * */

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
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
		INTERNAL_SERVER_ERROR_EXCEPTION("Internal server error.");
		
		private String message;
		
		private Codes(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
	}
}
