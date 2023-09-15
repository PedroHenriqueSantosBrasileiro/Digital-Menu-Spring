package com.digitalMenu.controller;

import com.digitalMenu.dto.DadosCadastroMesa;
import com.digitalMenu.model.Mesa;
import com.digitalMenu.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesa")
public class MesaController {
    @Autowired
    private MesaRepository repository;
    @PostMapping
    public ResponseEntity cadastrarMesa(@RequestBody DadosCadastroMesa dados){
        Mesa mesa = new Mesa(dados);

        repository.save(mesa);

        return ResponseEntity.ok(mesa);
    }
}
