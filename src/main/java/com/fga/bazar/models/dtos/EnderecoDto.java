package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Endereco;

import java.math.BigInteger;

public record EnderecoDto (
    Integer id,
    BigInteger cep,
    Integer numero,
    String bairro,
    String complemento,
    Integer cidadeId,

    Integer usuarioId
) {

    public EnderecoDto(Endereco endereco) {
        this(endereco.getId(), endereco.getCep(), endereco.getNumero(), endereco.getBairro(), endereco.getComplemento(), endereco.getCidade().getId(), endereco.getUsuario().getId());
    }

}
