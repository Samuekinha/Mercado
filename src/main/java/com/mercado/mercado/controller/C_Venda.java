package com.mercado.mercado.controller;

import com.mercado.mercado.model.M_Cliente;
import com.mercado.mercado.repository.R_Cliente;
import com.mercado.mercado.service.S_Venda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Venda")
public class C_Venda {

    private static R_Cliente r_cliente;
    private static S_Venda s_venda;

    public C_Venda (R_Cliente r_cliente, S_Venda s_venda){
        this.r_cliente = r_cliente;
        this.s_venda = s_venda;
    }

    @GetMapping("/Cadastro")
    public String gCadastrarVenda(Model model){

        List<M_Cliente> clientes = r_cliente.findAll();;
        model.addAttribute("clientes", clientes);

        return "/Venda/Cadastro";
    }

    @PostMapping("/Cadastro")
    public String pCadastrarVenda(){



        return "/Venda/Cadastro";
    }

    @PostMapping("/SelecionarCliente")
    public String pSelecionarCliente(@RequestParam("clienteId") Long id,
                                     Model model){

        if (s_venda.SelecionarCliente(id)){
            model.addAttribute("message", "Cliente selecionado!");
        } else{
            model.addAttribute("message", "Erro ao selecionar cliente.");
        }

        return null;
    }

}
