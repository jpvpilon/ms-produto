package com.github.jpvpilon.ms.produto.dto;

import com.github.jpvpilon.ms.produto.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        valor = produto.getValor();
    }
}
