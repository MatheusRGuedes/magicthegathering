package com.zappts.magicthegathering.service;
 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations; 
import org.springframework.test.context.ActiveProfiles;

import com.zappts.magicthegathering.core.exceptions.JogadorNotFoundException;
import com.zappts.magicthegathering.core.exceptions.BusinesException.Codes;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;
import com.zappts.magicthegathering.domain.service.JogadorService;

@ActiveProfiles("test")
public class JogadorServiceTest {

	@InjectMocks
	private JogadorService jogadorService;
	
	@Mock
	private JogadorRepository repository;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("Should return all jogadores with success.")
	void getAll() {
		
		jogadorService.getAll();
		
		Mockito.verify(repository, times(1)).findAll();
	}
	
	@Test
	@DisplayName("Should return jogador with success.")
	void findOneCase1() {
		
		final Long id = 1L;
		
		when(repository.existsById(id)).thenReturn(true);
		
		when(repository.findById(id))
			.thenReturn(Optional.of(new Jogador()));
		
		jogadorService.findOne(id);
		
		Mockito.verify(repository, times(1)).existsById(id);
		Mockito.verify(repository, times(1)).findById(id);
	}
	
	@Test
	@DisplayName("Should not return jogador with success.")
	void findOneCase2() { 
		
		final Long id = 1L;
		final String message = Codes.JOGADOR_NOT_FOUND_EXCEPTION.getMessage()
				.concat(" For id: ").concat(id.toString());
		
		when(repository.existsById(id)).thenReturn(false);
		
		Exception thrown = Assertions.assertThrows(JogadorNotFoundException.class, () -> {
			jogadorService.findOne(id);
		});		

		Assertions.assertEquals(message, thrown.getMessage());
	}

	@Test
	@DisplayName("Should create jogador with success.")
	void createCase1() { 
		
		Jogador jogador = new Jogador("matheus", "senha123");
		
		when(repository.findByUsername(any())).thenReturn(Optional.empty());
		
		jogadorService.create(jogador);
		
		verify(repository, times(1)).save(jogador);
	}
}
