package com.mercado.mercado.controller;

import com.mercado.mercado.service.S_Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Cliente")
public class C_Cliente {

    private static S_Cliente s_cliente;

    public C_Cliente (S_Cliente s_cliente){
        this.s_cliente = s_cliente;
    }

    @GetMapping("/Cadastro")
    public String getCadastroCliente(){
        return "Cliente/Cadastro";
    }

    @PostMapping("/Cadastro")
    public String postCadastroCliente(@RequestParam("NomeCliente") String nome,
                                    @RequestParam("EmailCliente") String email,
                                    @RequestParam("EndCliente") String endereco,
                                    @RequestParam("TelCliente") String telefone,
                                    Model model){

        if (s_cliente.cadastroCliente(nome, email, endereco, telefone))
            model.addAttribute("message", "Erro no Cadastro!");
        else {
            model.addAttribute("message", "Cadastrou!");
        }

        return "Cliente/Cadastro";
    }

}
