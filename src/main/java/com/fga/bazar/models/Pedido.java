package com.fga.bazar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;



    @Entity
    @Table(name = "Pedido")
    public class Pedido implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column( nullable = false)
        private Instant data;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "PEDIDO_USER_FK"))
        private Usuario usuario;

        // apenas referenciar a chave estrangeira
        @OneToOne(mappedBy = "pedido")
        private Pagamento pagamento;
        //
        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Instant getData() {
            return data;
        }

        public void setData(Instant data) {
            this.data = data;
        }

        public float calculaTotal(float subtotais){
            // calculo dos itens
            return subtotais;
        }


}

