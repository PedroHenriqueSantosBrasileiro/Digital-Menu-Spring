package com.digitalMenu.dto;

import com.digitalMenu.model.Categoria;

public record DadosCategoria(Integer id, String nome) {

    public DadosCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }

}
