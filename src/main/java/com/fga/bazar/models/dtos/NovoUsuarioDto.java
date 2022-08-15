package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NovoUsuarioDto implements Serializable {

    private Integer id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    private final List<EnderecoDto> enderecos = new ArrayList<EnderecoDto>();

    public NovoUsuarioDto() {}

    public NovoUsuarioDto(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public NovoUsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getEmail(), usuario.getSenha());
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }
}
