package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name="pagamento_dinheiro")
@JsonTypeName(value = "pagamentoDinheiro")
public abstract class PagamentoDinheiro extends Pagamento {

    @Column( nullable = false)
    
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id")
    private Float troco;
    private String nomePagador; 
    private Instant data;
    private String relatorio;

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
}
