package com.zappts.magicthegathering.api.config.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zappts.magicthegathering.core.exceptions.BusinesException;

public class ExceptionHandlerResponseBuilder {

	public BusinesException exception;
	public HttpStatus status;
	
	public ExceptionHandlerResponseBuilder(BusinesException exception, HttpStatus status) {
		this.exception = exception;
		this.status = status;
	}
	
	public ResponseEntity build() {
		Map<String, Object> map = new HashMap<>();
		map.put("code", exception.getCodes());
		map.put("message", exception.getMessage());
		return new ResponseEntity(map, status);
	}
}
