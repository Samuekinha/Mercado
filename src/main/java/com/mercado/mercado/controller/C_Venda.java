package com.mercado.mercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Venda")
public class C_Venda {

    @GetMapping("/Cadastrar")
    public String gCadastrarVenda(){
        return "/Venda/Cadastro";
    }

    @PostMapping("/Cadastrar")
    public String pCadastrarVenda(){



        return "/Venda/Cadastro";
    }
}
