package com.zappts.magicthegathering.service;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations; 
import org.springframework.test.context.ActiveProfiles;

import com.zappts.magicthegathering.core.exceptions.JogadorNotFoundException;
import com.zappts.magicthegathering.core.exceptions.UsernameExistsException; 
import com.zappts.magicthegathering.core.exceptions.BusinesException.Codes;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;
import com.zappts.magicthegathering.domain.service.JogadorService;

/* nested = aninhado */

@ActiveProfiles("test")
public class JogadorServiceTest {

	@InjectMocks
	private JogadorService jogadorService;
	
	@Mock
	private JogadorRepository repository;
	
	//captura o argumento passado para os métodos
	@Captor
	private ArgumentCaptor<Jogador> argumentCaptor;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	} 
	
	@Nested
	class findUser {
		
		@Test
		@DisplayName("Should return jogador with success.")
		void findOneCase1() {
			
			final Long id = 1L;
			
			// returna true ao chamar o método do mock
			when(repository.existsById(id)).thenReturn(true);
			
			when(repository.findById(id))
				.thenReturn(Optional.of(new Jogador()));
			
			jogadorService.findOne(id);
			
			Mockito.verify(repository, times(1)).existsById(id);
			Mockito.verify(repository, times(1)).findById(id);
		}
		
		@Test
		@DisplayName("Should not return jogador when jogador not exist.")
		void findOneCase2() { 
			
			final Long id = 1L;
			final String message = Codes.JOGADOR_NOT_FOUND_EXCEPTION.getMessage()
					.concat(" For id: ").concat(id.toString());
			
			when(repository.existsById(id)).thenReturn(false);
			
			// certifica que o código do lambda ira gerar a exceção
			Exception thrown = Assertions.assertThrows(JogadorNotFoundException.class, () -> {
				jogadorService.findOne(id);
			});		

			// verifica igualdade
			Assertions.assertEquals(message, thrown.getMessage());
		}
	}	

	@Nested
	class createUser  {
		
		@Test
		@DisplayName("Should create jogador with success.")
		void createCase1() { 
			
			final Jogador jogador = new Jogador("matheus", "senha123");
			
			when(repository.findByUsername(jogador.getUsername()))
				.thenReturn(Optional.empty());
			
			//captura exatamente o objeto com os valores
			when(repository.save(argumentCaptor.capture())).thenReturn(jogador);
			
			jogadorService.create(jogador);
			
			verify(repository, times(1)).save(jogador);
			
			final Jogador jogadorCaptured = argumentCaptor.getValue();
			
			assertEquals(jogador.getUsername(), jogadorCaptured.getUsername());
			assertEquals(jogador.getPassword(), jogadorCaptured.getPassword());
		}
		
		@Test
		@DisplayName("Should not create jogador with success.")
		void createCase2() {
			
			final Jogador jogador = new Jogador("matheus", "senha123");
					
			when(repository.findByUsername(any())).thenReturn(Optional.of(new Jogador()));
			
			Exception thrown = Assertions.assertThrows(UsernameExistsException.class, () -> {
				jogadorService.create(jogador);
			});	
			
			Assertions.assertEquals(Codes.USERNAME_EXISTS_EXCEPTION.getMessage(), 
					thrown.getMessage());
		}	
	}	
}
