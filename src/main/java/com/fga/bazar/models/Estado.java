package com.fga.bazar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fga.bazar.models.dtos.EstadoDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2, nullable = false, unique = true)
    private String sigla;

    @Column(length = 20, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Integer id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public Estado(EstadoDto estadoDto) {
        this(estadoDto.getId(), estadoDto.getSigla(), estadoDto.getNome());
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


    @JsonIgnore
    public List<Cidade> getCidades() {
        return cidades;
    }

}
