package com.example.transacctionproject.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transacctionproject.Entities.Cuenta;
import com.example.transacctionproject.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {
    List<Cuenta> anims;
    public AccountAdapter(List<Cuenta> anims) {
        this.anims = anims;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder vh, int position) {

        View itemView = vh.itemView;

        Cuenta pelicula = anims.get(position);

        TextView tvNombre= itemView.findViewById(R.id.tvNombre);
        TextView tvTipo = itemView.findViewById(R.id.tvTipo);
        TextView tvMonto = itemView.findViewById(R.id.tvMonto);


        tvNombre.setText(pelicula.Nombre);
        tvTipo.setText(pelicula.Tipo);
        tvMonto.setText(pelicula.Monto);


    }
    @Override
    public int getItemCount() {
        return anims.size();
    }

    class AccountViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    }
}