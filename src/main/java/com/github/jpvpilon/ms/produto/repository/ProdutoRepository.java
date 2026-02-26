package com.github.jpvpilon.ms.produto.repository;

import com.github.jpvpilon.ms.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
