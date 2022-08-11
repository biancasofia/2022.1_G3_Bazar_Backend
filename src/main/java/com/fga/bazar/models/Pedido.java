package com.fga.bazar.models;

import com.fga.bazar.models.composite.ProdutoComponent;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido extends ProdutoComponent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Instant data;

    @OneToMany(mappedBy = "id.pedido")
    private final List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {}

    public Pedido(Integer id, Instant data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public void adicionarItem(ItemPedido itemPedido) {
        this.itens.add(itemPedido);
    }

    @Override
    public void removerItem(ItemPedido itemPedido) {
        this.itens.remove(itemPedido);
    }

    @Override
    public float getPreco() {
        return itens.stream()
                .map(ItemPedido::getPreco)
                .reduce(0f, Float::sum);
    }

}
