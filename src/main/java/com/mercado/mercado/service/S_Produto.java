package com.mercado.mercado.service;

import com.mercado.mercado.model.M_Produto;
import com.mercado.mercado.repository.R_Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class S_Produto {

    @Autowired
    private static R_Produto r_produto;

    public S_Produto (R_Produto r_produto){
        this.r_produto = r_produto;
    }

    public Boolean cadastroProduto(String nome, String empresa, BigDecimal valor,
                                   String desc, BigInteger estoque){
        Boolean podeSalvar = true;

        if (nome != null && empresa != null && valor != null && desc != null &&
            estoque != null){

            List<M_Produto> m_produtos = r_produto.findAll();
            m_produtos = m_produtos.isEmpty() ? null : m_produtos;

            if (m_produtos != null){
                for (M_Produto m_produto : m_produtos) {
                    M_Produto produto = m_produtos.get(Math.toIntExact(m_produto.getId()));

                    String nomeP = produto.getNome();
                    String nomeE = produto.getEmpresa();
                    if (Objects.equals(nomeP, nome) && Objects.equals(nomeE, empresa)){
                        podeSalvar = false;
                        break;
                    }
                }
            }
        }

        if (podeSalvar){
            M_Produto m_produto = new M_Produto();

            m_produto.setNome(nome);
            m_produto.setEmpresa(empresa);
            m_produto.setPreco(valor);
            m_produto.setDescricao(desc);
            m_produto.setQuantidadeEstoque(estoque);
            r_produto.save(m_produto);
        }

        return podeSalvar;
    }

}
