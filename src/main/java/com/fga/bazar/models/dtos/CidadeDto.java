package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Cidade;

import java.io.Serializable;

public class CidadeDto implements Serializable {

    private Integer id;

    private String nome;

    private Integer estadoId;

    public CidadeDto() {}

    public CidadeDto(Integer id, String nome, Integer estadoId) {
        this.id = id;
        this.nome = nome;
        this.estadoId = estadoId;
    }

    public CidadeDto(Cidade cidade) {
        this(cidade.getId(), cidade.getNome(), cidade.getEstado().getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

}
