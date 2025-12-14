package com.zappts.magicthegathering.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zappts.magicthegathering.api.controller.JogadorController;
import com.zappts.magicthegathering.api.dto.JogadorDTO;
import com.zappts.magicthegathering.api.dto.ListaJogadorDTO;
import com.zappts.magicthegathering.domain.service.JogadorService;

/*
 * @MockMVC - é uma ferramenta que facilita na chamada das ações dos controllers
 * 			- testar se está recebendo a info correta
 * @AutoConfigureMockMvc - Não se preocupar em adicionar filtro de segurança
 * 
 * */

@WebMvcTest(controllers = JogadorController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class JogadorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JogadorService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private JogadorDTO jogadorDTO;	
	private ListaJogadorDTO ListaJogadorDTO;
	
	@BeforeEach
	public void init() {
		jogadorDTO = new JogadorDTO("teste", "12345");
		ListaJogadorDTO = new ListaJogadorDTO("lista 1");
	}
	
	@Test
	@DisplayName("Should Create Jogador With Success")
	public void shouldCreateJogadorWithSuccess() throws Exception {
		when(service.create(any())).thenAnswer(invocation -> invocation.getArgument(0));
		
		mockMvc.perform(post("/"));
	}
}
