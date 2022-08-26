package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fga.bazar.models.composite.ProdutoComponent;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "item_pedido")
public class ItemPedido extends ProdutoComponent implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @Column
    private Float desconto;

    @Column(nullable = false)
    private Float precoItem;

    @Column(nullable = false)
    private Integer quantidade;

    public ItemPedido() {}

    public ItemPedido(Pedido pedido, Produto produto, Float desconto, Float precoItem, Integer quantidade) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.precoItem = precoItem;
        this.quantidade = quantidade;
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.id.setPedido(pedido);
    }

    @JsonIgnore
    public Pedido getPedido() {
        return this.id.getPedido();
    }

    public void setProduto(Produto produto) {
        this.id.setProduto(produto);
    }

    public Produto getProduto() {
        return this.id.getProduto();
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

    public float getPreco() {
        return (precoItem - desconto) * quantidade;
    }

}
