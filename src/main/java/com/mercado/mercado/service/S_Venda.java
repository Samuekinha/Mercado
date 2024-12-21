package com.mercado.mercado.service;

import com.mercado.mercado.model.M_ClienteSelec;
import org.springframework.stereotype.Service;

@Service
public class S_Venda {

    private static M_ClienteSelec m_selecionado;

    public S_Venda (M_ClienteSelec m_selecionado){
        this.m_selecionado = m_selecionado;
    }

    public Boolean SelecionarCliente(Long id){

        if(id != null){
            m_selecionado.setClienteSelec(id);
            return true;
        } else{
            return false;
        }
    }

}
