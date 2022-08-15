package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Estado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstadoDto implements Serializable {

    private Integer id;

    private String sigla;

    private String nome;

    private final List<CidadeDto> cidades = new ArrayList<>();

    public EstadoDto() {}

    public EstadoDto(Integer id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.sigla = estado.getSigla();
        this.nome = estado.getNome();
        estado.getCidades()
                .stream()
                .map(CidadeDto::new)
                .forEach(this.cidades::add);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CidadeDto> getCidades() {
        return cidades;
    }

}
