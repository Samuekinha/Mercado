package com.mercado.mercado.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor  // Gera o construtor sem parâmetros para JPA
public class M_Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<M_Venda> vendas;

    // Construtor com parâmetros
    public M_Cliente(Long id, String nome, String email, String telefone, List<M_Venda> vendas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.vendas = vendas;
    }
}
