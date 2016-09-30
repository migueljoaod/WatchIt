package com.example.joaosampaio.watchit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;

/**
 * Created by joao.sampaio on 23/09/2016.
 */
public class SerieItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagemSerie;
    public TextView nomeSerie;
    public TextView anoSerie;
    public MaterialFavoriteButton favorito;


    public SerieItemViewHolder(View itemView) {
        super(itemView);
        imagemSerie = (ImageView) itemView.findViewById(R.id.imagemSerie);
        nomeSerie = (TextView) itemView.findViewById(R.id.text_serie_nome);
        anoSerie = (TextView) itemView.findViewById(R.id.text_serie_ano);
        favorito = (MaterialFavoriteButton) itemView.findViewById(R.id.favorito);
    }
}

