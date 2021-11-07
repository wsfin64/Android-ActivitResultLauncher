package com.example.planos;

import java.io.Serializable;

public class Plano implements Serializable {

    private String descricao;
    private int nota;

    public Plano(String descricao, int nota){
        this.descricao = descricao;
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Plano(){}
}
