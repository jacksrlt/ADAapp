package com.mijale.adaapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.fido.fido2.api.common.RequestOptions;
import com.mijale.adaapp.Entidades.Alerts;
import com.mijale.adaapp.Entidades.Persona;
import com.mijale.adaapp.R;

import java.util.ArrayList;

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Alerts> model;
    //listener
    private View.OnClickListener listener;


    public AlertsAdapter(Context context, ArrayList<Alerts> model) {
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


        String textoAlerts = model.get(position).getTextoAlerts();
        int imagenAlerts = model.get(position).getImagenAlerts();
        holder.textoAlerts.setText(textoAlerts);
        holder.imagenAlerts.setImageResource(imagenAlerts);
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
        ImageView imagenAlerts;
        TextView textoAlerts;


        public ViewHolder(View itemView) {
           super(itemView);
           this.imagenAlerts = itemView.findViewById(R.id.imagenAlerts);
           this.textoAlerts = itemView.findViewById(R.id.textoAlerts);
        }
    }
}
