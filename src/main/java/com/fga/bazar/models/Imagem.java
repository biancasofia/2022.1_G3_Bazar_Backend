package com.fga.bazar.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "imagem")
public class Imagem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = true, foreignKey = @ForeignKey(name = "IMAGEM_PRODUTO_FK"))
    private Produto produto;


    public Imagem(String imagemUrl, Produto produto) {
        this.imagemUrl = imagemUrl;
        this.produto = produto;
    }

    public Imagem() {
    }
    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
