package com.zappts.magicthegathering.api.config.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zappts.magicthegathering.core.exceptions.BusinesException;
import com.zappts.magicthegathering.core.exceptions.InternalServerErrorException;
import com.zappts.magicthegathering.core.exceptions.ArgumentNotValidException;

/*
 * ControllerAdvice --> Classe de aviso para o spring que será um bean manipulação chamado nas camadas
 * ExceptionHandler --> Invocação do método de acordo com o tipo da exceção gerado, através da anotação acima
 * */

@ControllerAdvice
public class ExceptionHandlerConfiguration {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> exceptionHandler(RuntimeException exception) {
		
		if (exception instanceof BusinesException) {
			return new ExceptionHandlerResponseBuilder(
					(BusinesException) exception, HttpStatus.BAD_REQUEST).build();
		}
		return new ExceptionHandlerResponseBuilder(
				new InternalServerErrorException(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> exceptionHandler(BindException exception) {
		return new ExceptionHandlerResponseBuilder(
				new ArgumentNotValidException(exception), HttpStatus.BAD_REQUEST).build();
	}
}
