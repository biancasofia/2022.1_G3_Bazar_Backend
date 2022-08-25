package com.fga.bazar.models.dtos;

import com.fga.bazar.models.PagamentoPix;
import com.fga.bazar.models.enums.StatusPagamento;

import java.io.Serializable;

public class PagamentoPixDto extends PagamentoDto implements Serializable {

    private String chavePix;

    public PagamentoPixDto() {
    }

    public PagamentoPixDto(Integer id, StatusPagamento statusPagamento, String chavePix) {
        super(id, statusPagamento);
        this.chavePix = chavePix;
    }

    public PagamentoPixDto(PagamentoPix pagamentoPix) {
        super(pagamentoPix.getId(), pagamentoPix.getStatusPagamento());
        this.chavePix = pagamentoPix.getChavePix();
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
