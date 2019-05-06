package com.example.a1069700.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerInterface {
    RecyclerView meuRecyclerView;
    LinearLayoutManager meuLayoutManager;
    MeuAdapter adapter;
    private ArvoreLista arvList = new ArvoreLista();
    EditText editNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.txtVnome);

        meuRecyclerView = (RecyclerView) findViewById(R.id.myRecView);

        meuLayoutManager = new LinearLayoutManager(this);
        meuRecyclerView.setLayoutManager(meuLayoutManager);
        adapter = new MeuAdapter(this, arvList, this);
        meuRecyclerView.setAdapter(adapter);
    }
    /*
    public void onClick(View v) {
        Contatos contato = new Contatos();
        contato.setNome(editNome.getText().toString());
        listaContatos.add(contato);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Object object) {
        Contatos contato = (Contatos) object;
        String nome = contato.getNome();
        editNome.setText(nome);
    } */
}
