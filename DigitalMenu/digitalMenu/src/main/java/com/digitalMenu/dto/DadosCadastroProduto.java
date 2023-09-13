package com.digitalMenu.dto;

public record DadosCadastroProduto(
        String nome,
        String descricao,
        double preco,
        boolean status,
        Integer id_categoria) {

}
