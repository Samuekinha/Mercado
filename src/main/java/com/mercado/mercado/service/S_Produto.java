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

    public boolean cadastrarProduto(String nome, String empresa, BigDecimal valor,
                                    String descricao, BigInteger estoque) {
        // Validação de parâmetros
        if (nome == null || empresa == null || valor == null || descricao == null || estoque == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }

        // Verifica se o produto já existe no banco
        boolean produtoExistente = r_produto.existsByNomeAndEmpresa(nome, empresa);

        if (produtoExistente) {
            return false; // Não permite salvar um produto duplicado
        }

        // Cria e salva o novo produto
        M_Produto novoProduto = new M_Produto();
        novoProduto.setNome(nome);
        novoProduto.setEmpresa(empresa);
        novoProduto.setPreco(valor);
        novoProduto.setDescricao(descricao);
        novoProduto.setQuantidadeEstoque(estoque);

        r_produto.save(novoProduto);

        return true; // Produto salvo com sucesso
    }

}
