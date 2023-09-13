package com.digitalMenu.controller;

import com.digitalMenu.dto.DadosCategoria;
import com.digitalMenu.dto.DadosInserirCategoria;
import com.digitalMenu.model.Categoria;
import com.digitalMenu.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity cadastrar(@RequestBody DadosInserirCategoria dados) {
        Categoria categoria = new Categoria(dados);
        repository.save(categoria);

        return ResponseEntity.ok().body(new DadosCategoria(categoria));
    }

    @GetMapping
    public ResponseEntity<Page<DadosCategoria>> listarCategorias(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosCategoria::new);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirCategoria(@PathVariable Integer id) {
        Categoria categoria = repository.getReferenceById(id);
        categoria.setStatus(false);
        repository.save(categoria);
        return ResponseEntity.ok("Excluido com sucesso");
    }
    
    
}
