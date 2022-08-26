package com.fga.bazar.models.dtos;

import com.fga.bazar.models.ItemPedido;

import java.io.Serializable;

public class ItemPedidoDto implements Serializable {

    private Float desconto;

    private Float precoItem;

    private Integer quantidade;

    private Float subTotal;

    private ProdutoDto produtoDto;

    public ItemPedidoDto() {
    }

    public ItemPedidoDto(Float desconto, Float precoItem, Integer quantidade, Float subTotal,
                         ProdutoDto produtoDto) {
        this.desconto = desconto;
        this.precoItem = precoItem;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
        this.produtoDto = produtoDto;
    }

    public ItemPedidoDto(ItemPedido itemPedido) {
        this.desconto = itemPedido.getDesconto();
        this.precoItem = itemPedido.getPrecoItem();
        this.quantidade = itemPedido.getQuantidade();
        this.subTotal = itemPedido.getPreco();
        this.produtoDto = new ProdutoDto(itemPedido.getProduto());
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(Float precoItem) {
        this.precoItem = precoItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public ProdutoDto getProduto() {
        return produtoDto;
    }

    public void setProdutoDto(ProdutoDto produtoDto) {
        this.produtoDto = produtoDto;
    }
}
