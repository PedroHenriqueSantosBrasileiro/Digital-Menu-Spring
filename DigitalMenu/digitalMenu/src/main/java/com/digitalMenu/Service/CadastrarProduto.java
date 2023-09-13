
package com.digitalMenu.Service;

import com.digitalMenu.dto.DadosCadastroProduto;
import com.digitalMenu.model.Categoria;
import com.digitalMenu.model.Produto;
import com.digitalMenu.repository.CategoriaRepository;
import com.digitalMenu.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarProduto {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    public void cadastrar(DadosCadastroProduto dados){
        
        Categoria categoria = categoriaRepository.getReferenceById(dados.id_categoria());
        
        Produto produto = new Produto(dados.nome(),dados.descricao(),dados.preco(),dados.status(),categoria);
        
        produtoRepository.save(produto);
        
    }
    
    
    
}
