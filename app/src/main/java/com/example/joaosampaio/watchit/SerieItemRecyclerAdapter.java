package com.example.joaosampaio.watchit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by joao.sampaio on 23/09/2016.
 */
public class SerieItemRecyclerAdapter extends RecyclerView.Adapter<SerieItemViewHolder> {

    private List<SerieItem> mLista;
    private Context mContext;
    private OnFavorito mFavoritoListener;

    @Override
    public SerieItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serie, parent,false);
        return new SerieItemViewHolder(layoutView);
    }


    @Override
    public void onBindViewHolder(SerieItemViewHolder holder, int position) {
        final SerieItem item = mLista.get(position);
        holder.anoSerie.setText(item.getAno());
        holder.nomeSerie.setText(item.getNome());
        Picasso.with(mContext).load(item.getImagemSerie()).into(holder.imagemSerie);
        holder.favorito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mFavoritoListener != null){
                    mFavoritoListener.onFavoritoClick(item, isChecked);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }


    public SerieItem getItem(int position){
        return mLista.get(position);
    }

    public SerieItemRecyclerAdapter(Context context, List<SerieItem> lista){
        mLista = lista;
        mContext = context;
    }

    public void setOnFavoritoListener(OnFavorito onFavorito){
        mFavoritoListener = onFavorito;
    }

    public interface OnFavorito{
        void onFavoritoClick(SerieItem item, boolean checked);
    }

}
