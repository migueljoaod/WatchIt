package com.example.joaosampaio.watchit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class ListaSeriesActivity extends AppCompatActivity {
    private MaterialSearchView searchView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listaserie, menu);
        return true;
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

    }
}


