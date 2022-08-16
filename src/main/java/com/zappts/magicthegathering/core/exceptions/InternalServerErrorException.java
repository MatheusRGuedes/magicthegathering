package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class InternalServerErrorException extends BusinesException {

	public String detailMessage;
	
	public InternalServerErrorException(String detailMessage) {
		super(Codes.INTERNAL_SERVER_ERROR_EXCEPTION);
		this.detailMessage = detailMessage;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() +" "+ detailMessage;
	}
}
