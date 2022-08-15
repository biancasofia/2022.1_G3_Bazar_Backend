package com.fga.bazar.models.composite;

import com.fga.bazar.models.ItemPedido;

public abstract class ProdutoComponent {

    public abstract float getPreco();

    public void adicionarItem(ItemPedido itemPedido) {}

    public void removerItem(ItemPedido itemPedido) {}

}
