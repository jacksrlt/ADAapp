package com.mijale.adaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mijale.adaapp.Entidades.Persona;
import com.mijale.adaapp.R;

import java.util.ArrayList;

public class AdapterListas extends RecyclerView.Adapter<AdapterListas.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Persona> model;
    //listener
    private View.OnClickListener listener;



    public AdapterListas(Context context,ArrayList<Persona> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

  public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
  }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String nombreuser = model.get(position).getNombredentro();
        String textodentro = model.get(position).getTextodentro();
        int imagen = model.get(position).getImagenId();
        holder.nombreuser.setText(nombreuser);
        holder.textodentro.setText(textodentro);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombreuser, textodentro;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreuser = itemView.findViewById(R.id.nombreuser);
            textodentro = itemView.findViewById(R.id.textodentro);
            imagen = itemView.findViewById(R.id.imagen);

        }
    }

}
