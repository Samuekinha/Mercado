package com.mercado.mercado.controller;

import com.mercado.mercado.model.M_Cliente;
import com.mercado.mercado.model.M_ClienteSelect;
import com.mercado.mercado.model.M_Produto;
import com.mercado.mercado.repository.R_Cliente;
import com.mercado.mercado.repository.R_Produto;
import com.mercado.mercado.service.S_Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Venda")
public class C_Venda {

    private R_Produto r_produto;
    private static R_Cliente r_cliente;
    private static S_Venda s_venda;
    @Autowired
    private M_ClienteSelect m_clienteSelect;


    public C_Venda (R_Cliente r_cliente, S_Venda s_venda, M_ClienteSelect m_clienteSelect,
                    R_Produto r_produto){
        this.r_cliente = r_cliente;
        this.s_venda = s_venda;
        this.m_clienteSelect = m_clienteSelect;
        this.r_produto = r_produto;
    }

    @GetMapping("/Cadastro")
    public String gCadastrarVenda(Model model){

        List<M_Cliente> clientes = r_cliente.findAll();
        model.addAttribute("clientes", clientes);

        List<M_Produto> produtos = r_produto.findAll();
        model.addAttribute("produtos", produtos);

        String NomeClienteSelect = m_clienteSelect.getClienteNome();
        Long IdClienteSelect = m_clienteSelect.getClienteId();

        if (IdClienteSelect != null || NomeClienteSelect != null){
            model.addAttribute("clienteSelecionado", m_clienteSelect);
        } else{
            M_ClienteSelect m_clienteSelectNull = new M_ClienteSelect();
            m_clienteSelectNull.setClienteId(0L);
            m_clienteSelectNull.setClienteNome("N/F");
            model.addAttribute("clienteSelecionado", m_clienteSelect);
        }

        return "/Venda/Cadastro";
    }

    @PostMapping("/Cadastro")
    public String pCadastrarVenda(){

        return null;
    }

    @PostMapping("/SelecionarCliente")
    public String pSelecionarCliente(@RequestParam("clienteId") Long id,
                                     Model model) {
        try {
            boolean sucesso = s_venda.SelecionarCliente(id);
            if (sucesso) {
                model.addAttribute("Sucesso!");
            } else {
                model.addAttribute("message", "Erro ao validar Cliente");
            }
        } catch (Exception e) {
            // Log do erro
            model.addAttribute("message", "Erro desconhecido;");
        }

        return "redirect:/Venda/Cadastro";
    }

    @PostMapping("/AdicionarItem")
    public String pAdicionarItem(@RequestParam("itemId") Long id,
                                     Model model) {
        try {
            boolean sucesso = s_venda.SelecionarCliente(id);
            if (sucesso) {
                model.addAttribute("Sucesso!");
            } else {
                model.addAttribute("message", "Erro ao validar Cliente");
            }
        } catch (Exception e) {
            // Log do erro
            model.addAttribute("message", "Erro desconhecido;");
        }

        return "redirect:/Venda/Cadastro";
    }

}
