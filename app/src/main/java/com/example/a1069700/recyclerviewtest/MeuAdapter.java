package com.example.a1069700.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {
    public static RecyclerInterface recyclerInterface;
    Context context;
    private ArvoreLista arvList;
    public MeuAdapter(Context ctx, ArvoreLista arvList, RecyclerInterface clickRecyclerInterface)
    {
        this.context = ctx;
        this.arvList = arvList;
        this.recyclerInterface = clickRecyclerInterface;
    }

    @Override
    public void onBindViewHolder(MeuViewHolder viewHolder, final int i) {
        Contatos contato = minhaLista.get(i);
        viewHolder.txtNome.setText(i + ":" +contato.getNome());
        viewHolder.txtTelefone.setText(contato.getTelefone());
        viewHolder.txtEmail.setText(contato.getEmail());

        viewHolder.btnDelete.setOnClickListener((new View.OnClickListener()
        {
            public void onClick (View v){
                Contatos contatoDeletado = minhaLista.get(i);
                minhaLista.remove(contatoDeletado);
                notifyItemRemoved(i);
                notifyDataSetChanged();
            } } ));

        viewHolder.btnDeleta.setOnClickListener((new View.OnClickListener()
        {
            public void onClick (View v){
                Contatos contatoDeletado = minhaLista.get(i);
                minhaLista.remove(contatoDeletado);
                notifyItemRemoved(i);
                notifyDataSetChanged();
            } } ));
    }

    @Override
    public MeuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dir,
                viewGroup, false);
        return new MeuViewHolder(itemView);
    }
    @Override
    public int getItemCount() {
        return arvList.n;
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
            btnEdit = itemView.findViewById(R.id.btnInsert);
            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerInterface.onItemClick(minhaLista.get(getLayoutPosition()));
                }}); */
        }
    }
}