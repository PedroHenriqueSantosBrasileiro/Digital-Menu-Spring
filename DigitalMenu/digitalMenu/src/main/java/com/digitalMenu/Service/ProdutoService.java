package com.digitalMenu.Service;

import com.digitalMenu.dto.DadosAtualizaProduto;
import com.digitalMenu.dto.DadosCadastroProduto;
import com.digitalMenu.model.Categoria;
import com.digitalMenu.model.Produto;
import com.digitalMenu.repository.CategoriaRepository;
import com.digitalMenu.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void cadastrar(DadosCadastroProduto dados) {

        Categoria categoria = categoriaRepository.getReferenceById(dados.id_categoria());

        Produto produto = new Produto(dados.nome(), dados.descricao(), dados.preco(), dados.status(), categoria);

        produtoRepository.save(produto);

    }

    public void atualizar(DadosAtualizaProduto dados) {
        Produto produto = produtoRepository.getReferenceById(dados.id());

        if (dados.nome() != null) {
            produto.setNome(dados.nome());

        }
        if (dados.descricao() != null) {
            produto.setDescricao(dados.descricao());

        }
        if (dados.preco() != 0) {
            produto.setPreco(dados.preco());

        }

        if (dados.categoria() != null) {
            Categoria categoria = categoriaRepository.getReferenceById(dados.categoria());
            produto.setCategoria(categoria);
        }

        produtoRepository.save(produto);

    }

}
