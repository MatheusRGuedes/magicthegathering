package com.zappts.magicthegathering.api.config.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * AuthenticationEntryPoint --> as exceções de segurança são iniciadas aqui.
 * 							--> Exceções de segurança são lançadas por trás do dispatcherServlet e 
 * 								antes chegar nos métodos dos Controllers;
 * 
 * HandlerExceptionResolver --> É Delegado o exceptionHandler para esta classe resolver, monta cabeçalho e outras cofigs;
 * 							--> Permite tratar exceções de segurança pelo ExceptionHandlerConfiguration.
 * 
 * @Qualifier 				--> specify which specific type of your implementation, you want
 * 
 * Classe para interceptar exceções de segurança e enviar respostas customizadas pro client.
 * */

@Deprecated
@Component("delegatedAuthenticationEntryPoint")
public class DelegatedAuthenticationEntryPoint implements AuthenticationEntryPoint {

//	@Autowired
//	@Qualifier("handlerExceptionResolver")
//	private HandlerExceptionResolver resolver;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		//resolver.resolveException(request, response, null, exception);
		response.setContentType("application/json;charset=UTF-8");
	    response.setStatus(403);
	    
	    ObjectMapper mapper = new ObjectMapper();
	    response.getWriter().write(mapper.writeValueAsString("Acesso Negado"));
	}

}
