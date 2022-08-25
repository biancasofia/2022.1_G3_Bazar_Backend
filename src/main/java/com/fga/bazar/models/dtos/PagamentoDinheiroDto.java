package com.fga.bazar.models.dtos;

import com.fga.bazar.models.PagamentoDinheiro;
import com.fga.bazar.models.enums.StatusPagamento;

public class PagamentoDinheiroDto extends PagamentoDto {

    private Float troco;

    public PagamentoDinheiroDto() {
        super();
    }

    public PagamentoDinheiroDto(Integer id, StatusPagamento statusPagamento, Float troco) {
        super(id, statusPagamento);
        this.troco = troco;
    }

    public PagamentoDinheiroDto(PagamentoDinheiro pagamentoDinheiro) {
        super(pagamentoDinheiro.getId(), pagamentoDinheiro.getStatusPagamento());
        this.troco = pagamentoDinheiro.getTroco();
    }

    public Float getDesconto() {
        return troco;
    }

    public void setDesconto(Float troco) {
        this.troco = troco;
    }
}
