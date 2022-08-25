package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Pagamento;
import com.fga.bazar.models.enums.StatusPagamento;

import java.io.Serializable;

public class PagamentoDto implements Serializable {

    private Integer id;

    private StatusPagamento statusPagamento;

    public PagamentoDto() {}

    public PagamentoDto(Integer id, StatusPagamento statusPagamento) {
        this.id = id;
        this.statusPagamento = statusPagamento;
    }

    public PagamentoDto(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.statusPagamento = pagamento.getStatusPagamento();
    }

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

}
