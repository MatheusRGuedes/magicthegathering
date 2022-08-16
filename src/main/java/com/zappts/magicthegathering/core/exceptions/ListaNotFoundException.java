package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class ListaNotFoundException extends BusinesException {

	public Long listaId;
	
	public ListaNotFoundException(Long listaId) {
		super(Codes.LISTA_NOT_FOUND_EXCEPTION);
		this.listaId = listaId;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() +" For id: "+ listaId.toString();
	}
}
