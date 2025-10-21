package com.zappts.magicthegathering.core.exceptions;

@SuppressWarnings("serial")
public class UsernameExistsException extends BusinesException{

	public UsernameExistsException() {
		super(Codes.USERNAME_EXISTS_EXCEPTION);
	}
}
