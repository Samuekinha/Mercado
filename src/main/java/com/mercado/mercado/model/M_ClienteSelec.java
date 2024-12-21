package com.mercado.mercado.model;

import org.springframework.stereotype.Component;

@Component
public class M_ClienteSelec {
    private Long ClienteSelec;

    public M_ClienteSelec(Long clienteSelec) {
        this.ClienteSelec = clienteSelec;
    }

    public Long getClienteSelec() {
        return ClienteSelec;
    }

    public void setClienteSelec(Long clienteSelec) {
        ClienteSelec = clienteSelec;
    }
}
