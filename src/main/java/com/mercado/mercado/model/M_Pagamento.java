package com.mercado.mercado.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pagamentos")
public class M_Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private M_Venda venda; // Relacionamento com Venda

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "valor_pago", nullable = false)
    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento", nullable = false)
    private StatusPagamento statusPagamento; // Enum para status de pagamento (PAGO, PENDENTE)

    public enum StatusPagamento {
        PENDENTE,
        PAGO
    }
}
