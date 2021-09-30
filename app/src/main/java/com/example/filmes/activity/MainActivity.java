package com.example.filmes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.filmes.R;
import com.example.filmes.adapter.Adapter;
import com.example.filmes.model.Filme;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new Adapter(criarFilmes());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

    }


    public void enviar(View view) {

        EditText nameInput = findViewById(R.id.nameInput);
        String titleMovie = nameInput.getText().toString();
        Filme filme = new Filme(titleMovie,"unknown","unknown");
        adapter.addFilme(filme);

    }

    public ArrayList<Filme> criarFilmes() {

        ArrayList<Filme> filmes = new ArrayList<Filme>();
        filmes.add(new Filme("Mortal Kombat","Luta","2020"));
        filmes.add(new Filme("Mortal Kombat","Luta","2020"));
        filmes.add(new Filme("Mortal Kombat","Luta","2020"));
        filmes.add(new Filme("Mortal Kombat","Luta","2020"));
        filmes.add(new Filme("Mortal Kombat","Luta","2020"));
        return filmes;

    }
}