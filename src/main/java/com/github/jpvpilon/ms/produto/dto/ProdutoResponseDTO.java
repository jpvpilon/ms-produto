package com.github.jpvpilon.ms.produto.dto;

import java.util.List;

public class ProdutoResponseDTO {
    private long id;
    private String nome;
    private String descricao;
    private Double valor;


    public ProdutoResponseDTO(long id, String nome, String descricao, Double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static List<ProdutoResponseDTO> createMock(){
        return List.of(
            new ProdutoResponseDTO(1L, "Smart TV", "Smart Tv 1", 2000.0),
            new ProdutoResponseDTO(2L, "Mouse Microsoft", "Mouse sem fio", 290.0),
            new ProdutoResponseDTO(3L, "Teclado Microsoft", "Teclado QWERTY com fio", 230.0)
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}


