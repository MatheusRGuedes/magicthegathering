package com.zappts.magicthegathering.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zappts.magicthegathering.core.exceptions.JogadorNotFoundException;
import com.zappts.magicthegathering.core.exceptions.UsernameExistsException;
import com.zappts.magicthegathering.domain.model.Jogador;
import com.zappts.magicthegathering.domain.repository.JogadorRepository;

@Service
public class JogadorService implements UserDetailsService {

    @Autowired
    private JogadorRepository repository;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Jogador> getAll() {
        return repository.findAll();
    }

    public Jogador findOne(Long id) {

        if (!repository.existsById(id)) {
            throw new JogadorNotFoundException(id);
        }

        Optional<Jogador> jogador = repository.findById(id);
        return jogador.get();
    }

    public Jogador create(Jogador jogador) {

        if (repository.findByUsername(jogador.getUsername()).isPresent()) {
            throw new UsernameExistsException();
        }
        jogador.setPassword(passwordEncoder.encode(jogador.getPassword()));
        return repository.save(jogador);
    }

    public Jogador update(Long id, Jogador request) {

        if (!repository.existsById(id)) {
            throw new JogadorNotFoundException(id);
        }

        request.setId(id);

        return repository.save(request);
    }

    public List<Jogador> delete(Long id) {

        if (!repository.existsById(id)) {
            throw new JogadorNotFoundException(id);
        }

        repository.deleteById(id);

        return getAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Jogador jogador = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for username: " + username));
        return jogador;
    }
}
