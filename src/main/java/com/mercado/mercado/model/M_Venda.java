package com.mercado.mercado.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "vendas")
public class M_Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private M_Cliente cliente; // Relacionamento com Cliente

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "venda")
    private List<M_ProdutoVenda> produtos; // Relacionamento com os produtos da venda

    @OneToOne(mappedBy = "venda")
    private M_Pagamento pagamento; // Relacionamento com Pagamento
}
