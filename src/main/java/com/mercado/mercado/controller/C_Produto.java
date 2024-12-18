package com.mercado.mercado.controller;

import com.mercado.mercado.service.S_Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.BigInteger;

@Controller
@RequestMapping("/Produto")
public class C_Produto {

    private static S_Produto s_produto;

    public C_Produto (S_Produto s_produto){
        this.s_produto = s_produto;
    }

    @GetMapping("/Cadastrar")
    public String gCadastrarProduto(){
        return "Produto/Cadastro";
    }

    @PostMapping("/Cadastrar")
    public String pCadastrarProduto(@RequestParam("NomeProduto") String nome,
                                    @RequestParam("NomeEmpresa") String empresa,
                                    @RequestParam("ValorProduto") BigDecimal valor,
                                    @RequestParam("DescProduto") String desc,
                                    @RequestParam("EstoqueProduto") BigInteger estoque,
                                    Model model){

        if(s_produto.cadastroProduto(nome, empresa, valor, desc, estoque)){
            model.addAttribute("message", "Cadastrado!");
        } else{
            model.addAttribute("message", "Erro no Cadastro.");
        }

        return "Produto/Cadastro";
    }

}
