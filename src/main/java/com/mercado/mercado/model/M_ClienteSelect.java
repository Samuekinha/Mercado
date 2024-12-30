package com.mercado.mercado.model;

import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Component
public class M_ClienteSelect implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long clienteId; // Armazena o ID do cliente selecionado
    private String clienteNome; // Armazena o nome do cliente selecionado

    public M_ClienteSelect() {
        // Construtor padrão
    }

    // Getters e Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    // Métodos adicionais, se necessário
    @Override
    public String toString() {
        return "M_ClienteSelect{" +
                "clienteId=" + clienteId +
                ", clienteNome='" + clienteNome + '\'' +
                '}';
    }
}
