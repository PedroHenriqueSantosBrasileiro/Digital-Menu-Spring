package com.digitalMenu.controller;

import com.digitalMenu.dto.DadosCadastroMesa;
import com.digitalMenu.model.Mesa;
import com.digitalMenu.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesa")
public class MesaController {
    @Autowired
    private MesaRepository repository;

    @PostMapping
    public ResponseEntity cadastrarMesa(@RequestBody DadosCadastroMesa dados) {
        Mesa mesa = new Mesa(dados);

        repository.save(mesa);

        return ResponseEntity.ok(mesa);
    }

    @GetMapping
    public ResponseEntity<Page<Mesa>> listarMesas(@PageableDefault(size = 10, sort = {"numeroMesa"}) Pageable paginacao) {
        var page = repository.findAll(paginacao);

        return ResponseEntity.ok(page);

    }

    @DeleteMapping("/{numeroMesa}")
    public ResponseEntity excluirMesa(@PathVariable Integer numeroMesa) {

        Mesa mesa = repository.getReferenceById(numeroMesa);
        mesa.setStatus(false);
        repository.save(mesa);
        
        return ResponseEntity.noContent().build();


    }
}
