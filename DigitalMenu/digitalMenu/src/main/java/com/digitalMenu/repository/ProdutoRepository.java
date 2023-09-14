
package com.digitalMenu.repository;

import com.digitalMenu.dto.DadosListagemProdutos;
import com.digitalMenu.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT new com.digitalMenu.dto.DadosListagemProdutos (p.nome, p.descricao, p.preco, c.nome) FROM Produto p JOIN p.categoria c")
    Page<DadosListagemProdutos> listarProdutos(Pageable page);
    
}
