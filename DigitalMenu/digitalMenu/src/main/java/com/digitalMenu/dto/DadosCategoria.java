package com.digitalMenu.dto;

import com.digitalMenu.model.Categoria;

public record DadosCategoria(Integer id, String nome,boolean status) {

    public DadosCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome(),categoria.isStatus());
    }

}
