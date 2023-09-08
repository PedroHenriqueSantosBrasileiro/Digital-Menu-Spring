package com.digitalMenu.controller;

import com.digitalMenu.dto.InserirCategoriaDto;
import com.digitalMenu.model.Categoria;
import com.digitalMenu.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    CategoriaRepository repository;
    
    
    @PostMapping
    public void cadastrar(@RequestBody InserirCategoriaDto dados){
        Categoria categoria = new Categoria(dados);
        repository.save(categoria);
    }
}
