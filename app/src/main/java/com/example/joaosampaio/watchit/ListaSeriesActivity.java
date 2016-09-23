package com.example.joaosampaio.watchit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListaSeriesActivity extends AppCompatActivity {
    private MaterialSearchView searchView;

    private SerieItemRecyclerAdapter mAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listaserie, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);


        return true;
    }

    private List<SerieItem> obterListaDeSeries() {
        List<SerieItem> lista = new ArrayList<>();

        SerieItem serieItem = new SerieItem();
        serieItem.setNome("FlaqPaue");
        serieItem.setAno("2016");
        serieItem.setImagemSerie("https://yt3.ggpht.com/-yNAv_FHxS-c/AAAAAAAAAAI/AAAAAAAAAAA/U5opn74eaZY/s900-c-k-no-mo-rj-c0xffffff/photo.jpg");

        lista.add(serieItem);

        return lista;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_series);
        //searchView = (MaterialSearchView) findViewById(R.id.search_view);

        //Inicializa o toolbar a partir do layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Define o título
        toolbar.setTitle("Séries");
        //Define o Toolbar como ActionBar
        //para permitir a compatibilidade
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new SerieItemRecyclerAdapter(this, obterListaDeSeries());
        recyclerView.setAdapter(mAdapter);

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(ListaSeriesActivity.this, "Pesquisar", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        try {
            run("");
        }catch (Exception e){

        }

    }

    private  String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}


