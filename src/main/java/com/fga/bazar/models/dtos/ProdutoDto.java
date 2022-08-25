package com.fga.bazar.models.dtos;

import java.io.Serializable;

public record ProdutoDto(
        Integer id,
        Integer quantidade
) implements Serializable {
}
