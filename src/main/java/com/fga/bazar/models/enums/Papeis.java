package com.fga.bazar.models.enums;

public enum Papeis {

    ADMIN(1),
    CLIENTE(2),
    VENDEDOR(3),
    FORNECEDOR(4);

    private final int id;

    Papeis(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int value() {
        return id;
    }

}
