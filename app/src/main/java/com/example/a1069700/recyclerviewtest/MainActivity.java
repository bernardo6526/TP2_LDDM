package com.example.a1069700.recyclerviewtest;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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

        meuRecyclerView = (RecyclerView) findViewById(R.id.myRecView);

        meuLayoutManager = new LinearLayoutManager(this);
        meuRecyclerView.setLayoutManager(meuLayoutManager);
        adapter = new MeuAdapter(this, arvList.raiz.filhos, this);
        meuRecyclerView.setAdapter(adapter);

        ImageButton inserir = (ImageButton) findViewById(R.id.btnInsert2);
        ImageButton deletar = (ImageButton) findViewById(R.id.btnDelete2);

        try{
        inserir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int pos = (arvList.raiz.filhos.size() + 1);
                arvList.inserir("raiz",Integer.toString(pos));
                adapter.notifyDataSetChanged();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                arvList.raiz.filhos.clear();
                adapter.notifyDataSetChanged();
            }
        }); }catch(Exception e){alerta(e.toString());}
    }

    public void onClick(View v) {
       /* Contatos contato = new Contatos();
        contato.setNome(editNome.getText().toString());
        listaContatos.add(contato);
        adapter.notifyDataSetChanged(); */
    }

    @Override
    public void onItemClick(Object object) {
       /*  Contatos contato = (Contatos) object;
        String nome = contato.getNome();
        editNome.setText(nome); */
    }
    void alerta(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s);
        builder.create().show();
    }
}
