package com.fga.bazar.models.dtos;

import com.fga.bazar.models.PagamentoDinheiro;
import com.fga.bazar.models.PagamentoPix;
import com.fga.bazar.models.Pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoDto implements Serializable {

    private Integer id;

    private UsuarioDto cliente;

    private EnderecoDto enderecoDeEntrega;

    private Float totalPedido;

    private PagamentoDto pagamentoDto;

    private final List<ItemPedidoDto> itens = new ArrayList<>();

    public PedidoDto() {}

    public PedidoDto(Integer id, UsuarioDto cliente, EnderecoDto enderecoDeEntrega,
                     Float totalPedido, PagamentoDto pagamentoDto) {
        this.id = id;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.totalPedido = totalPedido;
        this.pagamentoDto = pagamentoDto;
    }

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = new UsuarioDto(pedido.getCliente());
        this.enderecoDeEntrega = new EnderecoDto(pedido.getEnderecoEntrega());

        if (pedido.getPagamento() instanceof PagamentoDinheiro) {
            this.pagamentoDto = new PagamentoDinheiroDto((PagamentoDinheiro) pedido.getPagamento());
        } else {
            this.pagamentoDto = new PagamentoPixDto((PagamentoPix) pedido.getPagamento());
        }

        this.totalPedido = pedido.getPreco();

        pedido.getItens().forEach(item -> itens.add(new ItemPedidoDto(item)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioDto getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioDto cliente) {
        this.cliente = cliente;
    }

    public EnderecoDto getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(EnderecoDto enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public PagamentoDto getPagamento() {
        return pagamentoDto;
    }

    public void setPagamentoDto(PagamentoDto pagamentoDto) {
        this.pagamentoDto = pagamentoDto;
    }

    public Float getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public List<ItemPedidoDto> getItens() {
        return itens;
    }

}
