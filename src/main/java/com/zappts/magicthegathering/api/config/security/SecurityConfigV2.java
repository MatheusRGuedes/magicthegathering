package com.zappts.magicthegathering.api.config.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.zappts.magicthegathering.core.exceptions.UnauthorizedException;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.service.JogadorService;

/*
 * @EnableWebSecurity --> Diz ao spring que contêm as configurações de segurança
 * 
 * - Nessa classe não tem a implementação do UserDetailsService e o 
 * 	registro dele pelo AuthenticationManageBuilder,
 * - Mesmo assim, o spring já identifica o JogadorService como um bean pela 
 * 	 Anotação @Service, sendo chamado por aqui.
 * 
 * */

@Configuration
@EnableWebSecurity
public class SecurityConfigV2 {
	
	@Autowired
	private JogadorService userDetailsService;
	
	@Autowired
	@Qualifier("delegatedAuthenticationEntryPoint")
	private AuthenticationEntryPoint authEntryPoint;
	
	private String jogadorId;

	//@Autowired
	//private CustomAuthenticationProvider authProvider;
	
	
	public AuthenticationConverter authenticationConverter() {
		return new BasicAuthenticationConverter();
	}
	
	// Obtêm login e senha para dar prosseguimento ao fluxo de autenticação
	public AuthenticationManagerResolver<HttpServletRequest> resolver() {		
		return request -> {
			String uri = request.getRequestURI();
			//System.out.println(uri);
			
			if (uri.substring(uri.lastIndexOf("/")).length() > 1
					|| request.getRequestURI().contains("listas")) {
				this.jogadorId = request.getRequestURI().split("/")[3];
			}  else {
				this.jogadorId = null;
			}
			return jogadorAuthenticationManager();
		};
	}
	
	//Faz a autenticação
	public AuthenticationManager jogadorAuthenticationManager() {		
		return authentication -> {
			Jogador jogador = (Jogador) userDetailsService.loadUserByUsername(authentication.getName());
			if (this.jogadorId != null && !jogador.getId().toString().equals(this.jogadorId)) {
				throw new BadCredentialsException("teste");
			} else {
				return new UsernamePasswordAuthenticationToken(
						authentication.getName(), 
						authentication.getCredentials());
			}
		};
	}
	
	// setSuccessHandler -> prevenir comportamento de redirecionamento
	private AuthenticationFilter authenticationFilter() {
		AuthenticationFilter filter = new AuthenticationFilter(resolver(), authenticationConverter());
		filter.setSuccessHandler((req, res, auth) -> {});
		return filter;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.addFilterBefore(authenticationFilter(), BasicAuthenticationFilter.class);
		
		// config de autenticação proprio do secutity
		http
			.authorizeRequests((authorize) -> {
				authorize.antMatchers(HttpMethod.GET, "/jogadores").permitAll();
				authorize.antMatchers(HttpMethod.GET, "/jogadores/**").permitAll();
				authorize.anyRequest().authenticated();
			})
			.httpBasic(Customizer.withDefaults())
			.csrf((csrf) -> {
				csrf.disable();
			});
			//.exceptionHandling(handler -> {
			//	handler.authenticationEntryPoint(authEntryPoint);
			//});
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
