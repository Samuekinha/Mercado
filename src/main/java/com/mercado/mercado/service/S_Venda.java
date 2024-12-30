package com.mercado.mercado.service;

import com.mercado.mercado.model.M_Cliente;
import com.mercado.mercado.model.M_ClienteSelect;
import com.mercado.mercado.repository.R_Cliente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class S_Venda {

    private static M_ClienteSelect m_clienteSelect;
    private static R_Cliente r_cliente;

    public S_Venda (R_Cliente r_cliente, M_ClienteSelect m_clienteSelect){
        this.r_cliente = r_cliente;
        this.m_clienteSelect = m_clienteSelect;
    }

    //salva o cliente selecionado para a venda
    public Boolean SelecionarCliente(Long id){

        if (id != null) {
            Optional<M_Cliente> m_cliente = m_cliente = r_cliente.findById(id);

            if (m_cliente.isPresent()){
                M_Cliente m_clienteEncontrado = m_cliente.get();
                String clienteNome = m_clienteEncontrado.getNome();
                Long clienteId = m_clienteEncontrado.getId();

                m_clienteSelect.setClienteId(clienteId);
                m_clienteSelect.setClienteNome(clienteNome);
            } else {
                return false;
            }

            return true;
        } else {
            return false;
        }

    }

}
