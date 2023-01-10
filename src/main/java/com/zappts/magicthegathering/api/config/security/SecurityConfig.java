package com.zappts.magicthegathering.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zappts.magicthegathering.domain.service.JogadorService;

/*
 * EnableWebSecurity --> desabilita as configurações padrões do security e habilita so as confg personalizadas;
 * 
 * httpBasic() 		 --> padrão do spring security
 * and() 	   		 --> returna um builder para unir as customizações
 * userDatailService --> usa a lógica do metodo loadUser e usando o tipo UserDatails do security, fazendo o encode 
 * 						 senha;
 * 
 * Proteção contra ameças:
 * CSRF --> https://docs.spring.io/spring-security/reference/features/exploits/csrf.html
 * */

//@EnableWebSecurity
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JogadorService userDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// config de autenticação proprio secutity
		http.httpBasic()
			.and()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Config de autenticação em memória
		/*
		auth.inMemoryAuthentication()
			.withUser("matheus")
			.password(passwordEncoder().encode("12345"))
			.roles("ADMIN"); 
		*/
		
		// Config de autenticação usando jpa
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
