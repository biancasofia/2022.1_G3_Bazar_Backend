package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Papel;
import com.fga.bazar.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDto {

    private Integer id;

    private String nome;

    private final List<Papel> papeis = new ArrayList<>();

    public UsuarioDto() {}

    public UsuarioDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome());
        this.papeis.addAll(usuario.getPapeis());
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

    public List<Papel> getPapeis() {
        return papeis;
    }

}
