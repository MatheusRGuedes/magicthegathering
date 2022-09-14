package com.zappts.magicthegathering.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private JogadorRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Jogador jogador = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for username: "+ username));
		return jogador;
	}
}
