package com.zappts.magicthegathering.domain.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Jogador - Response")
@Table(name = "jogadores")
@Entity
public class Jogador implements UserDetails {
	private static final long serialVersionUID = -1552132817024777471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "jogador", cascade = CascadeType.REMOVE)
	private List<ListaJogador> listas;
	
	
	public Jogador() {}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<ListaJogador> getListas() {
		return listas;
	}
	public void setListas(List<ListaJogador> listas) {
		this.listas = listas;
	}

	//METODOS SEGURANÇA
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
