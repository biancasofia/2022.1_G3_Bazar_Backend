package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fga.bazar.models.enums.StatusPagamento;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="PagamentoPix")
@JsonTypeName(value = "pagamentoPix")
public class PagamentoPix extends Pagamento {
    @Column(nullable = false)
    private String chavePix;
    @Column(nullable = false)
    private String nomePagador;

    @Column(nullable = false)
    private Date data;

    private String relatorio;
    public PagamentoPix() {
        super();
    }

    public PagamentoPix(Integer id, StatusPagamento statusPagamento, Pedido pedido,
                        String chavePix, String nomePagador, String relatorio, Date data) {
        super(id, statusPagamento, pedido);
        this.chavePix = chavePix;
        this.nomePagador = nomePagador;
        this.relatorio = relatorio;
        this.data = data;
    }

    public String gerarRelatorio() {
        return relatorio;
    }

    public String getChavePix(){
        return chavePix;
    }

    public void setChavePix(String chavePix){
        this.chavePix = chavePix;
    } 

    public String getNomePagador(){
        return nomePagador;
    }

    public void setNomePagador(String nomePagador){
        this.nomePagador = nomePagador;
    }

    public Date getData(){
        return data;
    }

    public void setdata(Date data){
        this.data = data;
    } 

}
