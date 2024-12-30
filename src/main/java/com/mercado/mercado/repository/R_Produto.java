package com.mercado.mercado.repository;

import com.mercado.mercado.model.M_Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Produto extends JpaRepository<M_Produto, Long> {
    boolean existsByNomeAndEmpresa(String nome, String empresa);
}

