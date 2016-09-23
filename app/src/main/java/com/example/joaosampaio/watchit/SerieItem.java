package com.example.joaosampaio.watchit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joao.sampaio on 22/09/2016.
 */
public class SerieItem {
    private String nome;
    private String ano;

    public String getImagemSerie() {
        return imagemSerie;
    }

    public void setImagemSerie(String imagemSerie) {
        this.imagemSerie = imagemSerie;
    }

    private String imagemSerie;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }





}

