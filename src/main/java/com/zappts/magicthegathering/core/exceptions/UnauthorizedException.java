package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class UnauthorizedException extends BusinesException {

	public UnauthorizedException() {
		super(Codes.UNAUTHORIZED_EXCEPTION);
	}
}
