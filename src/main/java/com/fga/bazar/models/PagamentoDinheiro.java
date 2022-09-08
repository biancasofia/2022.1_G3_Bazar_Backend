package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fga.bazar.models.enums.StatusPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name="pagamento_dinheiro")
@JsonTypeName(value="pagamentoDinheiro")
public class PagamentoDinheiro extends Pagamento {

    @Column()
    private Float troco;
    @Column(nullable = false)
    private String nomePagador;
    @Column(nullable = false)
    private Instant data;

    private String relatorio;

    public PagamentoDinheiro() {}

    public PagamentoDinheiro(Integer id, StatusPagamento statusPagamento, Pedido pedido,
                             Float troco, String nomePagador, Instant data, String relatorio) {
        super(id, statusPagamento, pedido);
        this.troco = troco;
        this.nomePagador = nomePagador;
        this.data = data;
        this.relatorio = relatorio;
    }

    @Override
    public String gerarRelatorio() {
        return relatorio;
    }
    
    public Float getTroco(){
        return troco;
    }

    public void setTroco(float troco){
        this.troco = troco;
    } 

    public String getNomePagador(){
        return nomePagador;
    }

    public void setNomePagador(String nomePagador){
        this.nomePagador = nomePagador;
    }

    public Instant getData(){
        return data;
    }

    public void setdata(Instant data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "PagamentoDinheiro{" +
                "troco=" + troco +
                ", nomePagador='" + nomePagador + '\'' +
                ", data=" + data +
                ", relatorio='" + relatorio + '\'' +
                '}';
    }
}
