package com.mercado.mercado.service;

import com.mercado.mercado.model.M_Cliente;
import com.mercado.mercado.repository.R_Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Cliente {

    private static R_Cliente r_cliente;

    public S_Cliente(R_Cliente r_cliente){
        this.r_cliente = r_cliente;
    }

    public static Boolean cadastroCliente(String nome, String email,
                                          String endereco, String telefone){
        Boolean podeSalvar = true;

        if (nome != null && email != null && endereco != null && telefone != null){
            List<M_Cliente> m_clientes = r_cliente.findAll();

            for (M_Cliente m_cliente : m_clientes) {

                String emails = m_cliente.getEmail();
            }



        } else {
            podeSalvar = false;
        }

        return podeSalvar;
    }

}
