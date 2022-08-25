package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="PagamentoPix")
@JsonTypeName(value = "pagamentoPix")
public abstract class PagamentoPix extends Pagamento {

    private String chavePix;
    private String nomePagador; 
    private String relatorio;
    private Date data;

    @Column( nullable = false)
    
    
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
