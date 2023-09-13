
package com.digitalMenu.repository;

import com.digitalMenu.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
}
