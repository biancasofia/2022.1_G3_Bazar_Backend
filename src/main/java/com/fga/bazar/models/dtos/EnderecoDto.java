package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Endereco;

import java.math.BigInteger;

public record EnderecoDto (
    BigInteger cep,
    Integer numero,
    String bairro,
    String complemento
) {

    public EnderecoDto(Endereco endereco) {
        this(endereco.getCep(), endereco.getNumero(), endereco.getBairro(), endereco.getComplemento());
    }

}
