package com.digitalMenu.controller;

import com.digitalMenu.Service.ProdutoService;
import com.digitalMenu.dto.DadosAtualizaProduto;
import com.digitalMenu.dto.DadosCadastroProduto;
import com.digitalMenu.dto.DadosDetalhamentoProduto;
import com.digitalMenu.dto.DadosListagemProdutos;
import com.digitalMenu.model.Produto;
import com.digitalMenu.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody DadosCadastroProduto dados) {

        produtoService.cadastrar(dados);

        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProdutos>> listarProdutos(@PageableDefault(size = 10) Pageable paginacao) {
        Page<DadosListagemProdutos> dados = repository.listarProdutos(paginacao);

        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamentoProduto(@PathVariable Integer id){
        Produto produto = repository.getReferenceById(id);
        DadosDetalhamentoProduto dados = new DadosDetalhamentoProduto(produto);
        return ResponseEntity.ok(dados);
    }


    @PutMapping
    public ResponseEntity atualizarProduto(@RequestBody DadosAtualizaProduto dados){
        produtoService.atualizar(dados);
        
        return ResponseEntity.ok().build();
    }


    
}
