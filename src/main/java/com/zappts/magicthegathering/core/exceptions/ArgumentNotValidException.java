package com.zappts.magicthegathering.core.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@SuppressWarnings("serial")
public class ArgumentNotValidException extends BusinesException {

	private List<Error> errors;
	
	public ArgumentNotValidException(final BindException exception) {
		super(Codes.METHOD_ARGUMENT_NOT_VALID_EXCEPTION);
		this.errors = new ArrayList<>();
		
		buildErrors(exception);
	}

	public List<Error> getErrors() {
		return errors;
	}
	
	private void buildErrors(final BindException exception) {
		BindingResult bindingResult = exception.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for(FieldError fieldError : fieldErrors) {
			errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
		}
	}
	
	private class Error {
		private String field;
		private String message;
		
		public Error(String field, String message) {
			this.field = field;
			this.message = message;
		}
		
		public String getField() {
			return field;
		}

		public String getMessage() {
			return message;
		}
	}
}
