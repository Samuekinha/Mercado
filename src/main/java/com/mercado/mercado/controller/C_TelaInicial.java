package com.mercado.mercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_TelaInicial {

    @GetMapping("/Inicial")
    public String getPaginaInicial(){
        return "/PaginaInicial";
    }

}
