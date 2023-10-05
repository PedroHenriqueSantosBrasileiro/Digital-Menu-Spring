
package com.digitalMenu.model;

import com.digitalMenu.dto.DadosCategoria;
import com.digitalMenu.dto.DadosInserirCategoria;
import jakarta.persistence.*;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    
    private boolean status;
    
    public Categoria(DadosInserirCategoria dados) {
        this.nome = dados.nome();
        this.status = true;
    }

    public Categoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void atualizar(DadosCategoria dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        
    }
    
}
