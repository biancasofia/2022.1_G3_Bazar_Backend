package com.fga.bazar.models;

import com.fga.bazar.models.dtos.CidadeDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false, foreignKey = @ForeignKey(name = "CIDADE_ESTADO_FK"))
    private Estado estado;

    public Cidade() {}

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade(CidadeDto cidadeDto) {
        this(cidadeDto.getId(), cidadeDto.getNome(), new Estado(cidadeDto.getEstadoId(), null, null));
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
