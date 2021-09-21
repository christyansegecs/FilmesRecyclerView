package com.example.filmes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.filmes.R;
import com.example.filmes.adapter.Adapter;
import com.example.filmes.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        this.criarFilmes();

        Adapter adapter = new Adapter(listaFilmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
        
    }

    public void criarFilmes() {

        Filme filme = new Filme("Mortal Kombat","Luta","2021");
        this.listaFilmes.add(filme);

        filme = new Filme("Clube da Luta","Drama","1999");
        this.listaFilmes.add(filme);

        filme = new Filme("Inception","Action","2010");
        this.listaFilmes.add(filme);

        filme = new Filme("The Lord of the Rings: The Return of the King","Adventure","2003");
        this.listaFilmes.add(filme);

        filme = new Filme("Pulp Fiction","Drama","1994");
        this.listaFilmes.add(filme);


    }

}