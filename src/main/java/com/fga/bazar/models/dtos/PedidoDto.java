package com.fga.bazar.models.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoDto implements Serializable {

    private Integer id;

    private Integer clienteId;

    private Integer enderecoDeEntregaId;

    private PagamentoDto pagamentoDto;

    private final List<ProdutoDto> itens = new ArrayList<>();

    public PedidoDto() {}

    public PedidoDto(Integer id, Integer clienteId, Integer enderecoDeEntregaId, PagamentoDto pagamentoDto) {
        this.id = id;
        this.clienteId = clienteId;
        this.enderecoDeEntregaId = enderecoDeEntregaId;
        this.pagamentoDto = pagamentoDto;
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

    public PagamentoDto getPagamentoDto() {
        return pagamentoDto;
    }

    public void setPagamentoDto(PagamentoDto pagamentoDto) {
        this.pagamentoDto = pagamentoDto;
    }

    public List<ProdutoDto> getItens() {
        return itens;
    }

}
