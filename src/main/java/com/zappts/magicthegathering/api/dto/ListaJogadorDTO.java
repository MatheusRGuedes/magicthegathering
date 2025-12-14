package com.zappts.magicthegathering.api.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Lista Jogador - Request")
public class ListaJogadorDTO {

    @Length(max = 60)
    @NotBlank
    private String nome;

    public ListaJogadorDTO() {
    }

    public ListaJogadorDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}