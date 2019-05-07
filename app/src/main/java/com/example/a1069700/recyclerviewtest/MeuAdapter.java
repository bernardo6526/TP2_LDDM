package com.example.a1069700.recyclerviewtest;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {
    public static RecyclerInterface recyclerInterface;
    Context context;
    private ArrayList<No> minhaLista;
    private RecyclerView myRecView;
    public MeuAdapter(Context ctx, ArrayList<No> minhaLista, RecyclerInterface clickRecyclerInterface)
    {
        this.context = ctx;
        this.minhaLista = minhaLista;
        this.recyclerInterface = clickRecyclerInterface;

    }

    @Override
    public void onBindViewHolder(MeuViewHolder viewHolder, final int i) {
        No no = minhaLista.get(i);
        viewHolder.txtDir.setText(no.conteudo);

        viewHolder.btnDelete.setOnClickListener((new View.OnClickListener()
        {
            public void onClick (View v){
                No noDeletado = minhaLista.get(i);
                minhaLista.remove(noDeletado);
                notifyItemRemoved(i);
                notifyDataSetChanged();
            } } ));

        RecyclerView meuRecyclerView;
        LinearLayoutManager meuLayoutManager;
        final MeuAdapter adapter;

        meuLayoutManager = new LinearLayoutManager(context);
        myRecView.setLayoutManager(meuLayoutManager);
        adapter = new MeuAdapter(context,minhaLista.get(i).filhos,recyclerInterface);
        myRecView.setAdapter(adapter);

        viewHolder.btnInsert.setOnClickListener((new View.OnClickListener()
        {
            public void onClick (View v){
                try {
                    String conteudo = minhaLista.get(i).conteudo + "." + Integer.toString(minhaLista.get(i).filhos.size() + 1);
                    No noNovo = new No(minhaLista.get(i), conteudo, false);
                    minhaLista.get(i).filhos.add(noNovo);
                    //alerta(minhaLista.get(i).filhos.get(0).conteudo);
                    adapter.notifyItemInserted(i);
                    adapter.notifyDataSetChanged();
                }catch(Exception e){alerta(e.toString());}
            } } ));

    }

    void alerta(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(s);
        builder.create().show();
    }

    @Override
    public MeuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dir,
                viewGroup, false);
        return new MeuViewHolder(itemView);
    }
    @Override
    public int getItemCount() {
        return minhaLista.size();
    }

    protected class MeuViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtDir;
        protected ImageButton btnInsert;
        protected ImageButton btnDelete;
        protected ImageButton btnEdit;

        public MeuViewHolder(final View itemView) {
            super(itemView);
            txtDir = itemView.findViewById(R.id.txtDir);
            btnInsert = itemView.findViewById(R.id.btnInsert);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            myRecView = itemView.findViewById(R.id.myRecView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerInterface.onItemClick(minhaLista.get(getLayoutPosition()));
                }});
        }
    }
}