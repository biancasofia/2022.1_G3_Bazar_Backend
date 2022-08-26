package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fga.bazar.models.enums.StatusPagamento;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "pagamento")
    @Inheritance(strategy = InheritanceType.JOINED)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = PagamentoDinheiro.class, name = "pagamentoDinheiro"),
        @JsonSubTypes.Type(value = PagamentoPix.class, name = "pagamentoPix")
    })
    public class Pagamento implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        // classe do tipo StatusPagamento, está string a nivel de exemplo
        @Column(nullable = false)
        private StatusPagamento statusPagamento;

        @JsonIgnore
        @OneToOne
        @JoinColumn(name = "pedido_id", nullable = false)
        @MapsId
        private Pedido pedido;

        public Pagamento() {}

        public Pagamento(Integer id, StatusPagamento statusPagamento, Pedido pedido) {
            this.id = id;
            this.statusPagamento = statusPagamento;
            this.pedido = pedido;
        }

        public String gerarRelatorio() {return "";}

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public StatusPagamento getStatusPagamento() {
            return statusPagamento;
        }

        public void setStatusPagamento(StatusPagamento statusPagamento) {
            this.statusPagamento = statusPagamento;
        }

        public Pedido getPedido() {
            return pedido;
        }

        public void setPedido(Pedido pedido) {
            this.pedido = pedido;
        }

        @Override
        public String toString() {
            return "Pagamento{" +
                    "id=" + id +
                    ", statusPagamento=" + statusPagamento +
                    ", pedido=" + pedido +
                    '}';
        }
    }
