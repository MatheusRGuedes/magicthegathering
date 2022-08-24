package com.zappts.magicthegathering.api.config.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zappts.magicthegathering.core.exceptions.ArgumentNotValidException;
import com.zappts.magicthegathering.core.exceptions.BusinesException;

public class ExceptionHandlerResponseBuilder {

	public Exception exception;
	public HttpStatus status;
	
	public ExceptionHandlerResponseBuilder(Exception exception, HttpStatus status) {
		this.exception = exception;
		this.status = status;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity build() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("code", ((BusinesException) exception).getCodes());
		map.put("message", exception.getMessage());
		
		if(exception instanceof ArgumentNotValidException) {
			map.put("errors", ((ArgumentNotValidException) exception).getErrors());
		}
		
		return new ResponseEntity(map, status);
	}
}
