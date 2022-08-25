package com.fga.bazar.models.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoDto implements Serializable {

    private Integer id;
    private Integer clienteId;
    private Integer enderecoDeEntregaId;
    private final List<ProdutoDto> itens = new ArrayList<>();

    public PedidoDto() {}

    public PedidoDto(Integer id, Integer clienteId, Integer enderecoDeEntregaId) {
        this.id = id;
        this.clienteId = clienteId;
        this.enderecoDeEntregaId = enderecoDeEntregaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getEnderecoDeEntregaId() {
        return enderecoDeEntregaId;
    }

    public void setEnderecoDeEntregaId(Integer enderecoDeEntregaId) {
        this.enderecoDeEntregaId = enderecoDeEntregaId;
    }

    public List<ProdutoDto> getItens() {
        return itens;
    }

}
