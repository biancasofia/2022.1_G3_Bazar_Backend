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

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "PEDIDO_CLIENTE_FK"))
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id", nullable = false, foreignKey = @ForeignKey(name = "PEDIDO_ENDERECO_FK"))
    private Endereco enderecoEntrega;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private final List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {}

    public Pedido(Integer id, Instant data, Usuario cliente, Endereco enderecoEntrega, Pagamento pagamento) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
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

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
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

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", cliente=" + cliente +
                ", enderecoEntrega=" + enderecoEntrega +
                ", pagamento=" + pagamento +
                ", itens=" + itens +
                '}';
    }
}

