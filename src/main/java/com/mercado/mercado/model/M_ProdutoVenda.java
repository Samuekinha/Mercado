package com.mercado.mercado.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produtos_venda")
public class M_ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto_venda")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private M_Venda venda; // Relacionamento com Venda

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private M_Produto produto; // Relacionamento com Produto

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;
}
