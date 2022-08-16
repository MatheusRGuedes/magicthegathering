package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class CartaNotFoundException extends BusinesException {

	public Long id;
	
	public CartaNotFoundException(Long id) {
		super(Codes.CARTA_NOT_FOUND_EXCEPTION);
		this.id = id;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() +" For id: "+ this.id.toString();
	}
}
