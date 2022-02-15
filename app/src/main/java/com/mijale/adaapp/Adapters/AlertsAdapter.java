package com.mijale.adaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mijale.adaapp.Entidades.Alerts;
import com.mijale.adaapp.R;

import java.util.ArrayList;

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Alerts> modelo;
    //listener
    private View.OnClickListener listener;


    public AlertsAdapter(Context context, ArrayList<Alerts> modelo) {
        this.inflater = LayoutInflater.from(context);
        this.modelo = modelo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.staggered, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String textoAlerts = modelo.get(position).getTextoAlerts();
        int imagenAlerts = modelo.get(position).getImagenAlerts();
        holder.textoAlerts.setText(textoAlerts);
        holder.imagenAlerts.setImageResource(imagenAlerts);
    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenAlerts;
        TextView textoAlerts;


        public ViewHolder(@NonNull View itemView) {
           super(itemView);
           imagenAlerts = itemView.findViewById(R.id.imagenAlerts);
           textoAlerts = itemView.findViewById(R.id.textoAlerts);
        }
    }
}
