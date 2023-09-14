package com.digitalMenu.dto;

import com.digitalMenu.model.Categoria;
import com.digitalMenu.model.Produto;

public record DadosDetalhamentoProduto(Integer id, String nome, String descricao, double preco, boolean status, Categoria categoria) {

public DadosDetalhamentoProduto(Produto produto){ this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.isStatus(),produto.getCategoria());}

}
