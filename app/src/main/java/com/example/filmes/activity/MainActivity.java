package com.example.filmes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.filmes.R;
import com.example.filmes.RecyclerItemClickListener;
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


        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void enviar(View view) {

        EditText nameInput = findViewById(R.id.nameInput);
        Button addButton = (Button) findViewById(R.id.button);

        String titleMovie = nameInput.getText().toString();
        Filme filme = new Filme(titleMovie,"unknown","unknown");
        this.listaFilmes.add(filme);

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