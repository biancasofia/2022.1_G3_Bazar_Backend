package com.fga.bazar.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = true, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @ElementCollection
    @CollectionTable(name = "telefone")
    @Column(name = "telefone", nullable = false, length = 15)
    private final Set<String> telefones = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_papeis",
        joinColumns = @JoinColumn(name = "usuario_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "papel_id", nullable = false)
    )
    private final List<Papel> papeis = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private final List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private final List<Pedido> pedidos = new ArrayList<>();

    public Usuario() {}

    public Usuario(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
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

    public List<Papel> getPapeis() {
        return papeis;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return papeis.stream()
                .map(papel -> new SimpleGrantedAuthority(papel.getAutoridade()))
                .toList();
    }

    public boolean hasPapel(String autoridade) {
        return papeis.stream()
                .anyMatch(papel -> papel.getAutoridade().equals(autoridade));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
