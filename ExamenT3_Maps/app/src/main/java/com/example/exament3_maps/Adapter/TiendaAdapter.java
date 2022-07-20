package com.example.exament3_maps.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.exament3_maps.TiendaActivity;
import com.example.exament3_maps.Entities.Tienda;
import com.example.exament3_maps.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TiendaAdapter extends RecyclerView.Adapter<TiendaAdapter.ContactViewHolder> {
    List<Tienda> contacts;
    public TiendaAdapter(List<Tienda> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {

        View itemView = vh.itemView;

        Tienda contact = contacts.get(position);

        TextView tvTitulo = itemView.findViewById(R.id.tvTiendaTitulo);
       // TextView tvResumen = itemView.findViewById(R.id.tvTiednResumen);
        //TextView tvAutor = itemView.findViewById(R.id.tvTiendaTitulo);
        //TextView tvFecha = itemView.findViewById(R.id.tvTiendaTitulo);
        //TextView tvTienda1 = itemView.findViewById(R.id.tvTiendaTitulo);
        //TextView tvTienda2 = itemView.findViewById(R.id.tvTiendaTitulo);
        //TextView tvTienda3 = itemView.findViewById(R.id.tvTiendaTitulo);

        ImageView ivAvatar = itemView.findViewById(R.id.ivAvatar );


        tvTitulo.setText(contact.Titulo);

        //Integer.parseInt(tvContactRegion.setText(contact.Numero));
        //Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/"+contact.Numero+".svg").into(ivAvatar);
       Picasso.get().load("https://static.wikia.nocookie.net/dragonball/images/2/2e/Goku_Joven_Flashback.jpg/revision/latest?cb=20170809015919&path-prefix=es").into(ivAvatar);
        Button btnDetalle = itemView.findViewById(R.id.btnDetalle);
        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), TiendaActivity.class);

                String contactJSON = new Gson().toJson(contact);
                intent.putExtra("CONTACT", contactJSON);
               // intent.putExtra("position", position);


                itemView.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Tienda contact = contacts.get(i);
            Log.i("APP_VJ20202", "click en el elemento" + contact.Id);
        }
    }
}
