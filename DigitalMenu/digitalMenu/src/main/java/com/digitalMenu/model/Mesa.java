package com.digitalMenu.model;

import com.digitalMenu.dto.DadosCadastroMesa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroMesa;

    private boolean status;

    public Mesa() {
    }

    public Mesa(DadosCadastroMesa dados) {
        this.numeroMesa = dados.numeroMesa();
        this.status = true;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "numeroMesa=" + numeroMesa +
                ", status=" + status +
                '}';
    }
}
