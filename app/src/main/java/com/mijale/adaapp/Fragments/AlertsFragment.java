package com.mijale.adaapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.google.firebase.firestore.DocumentReference;
import com.mijale.adaapp.Adapters.AdapterListas;
import com.mijale.adaapp.Adapters.AlertsAdapter;
import com.mijale.adaapp.Entidades.Alerts;
import com.mijale.adaapp.Entidades.Persona;
import com.mijale.adaapp.R;

import java.util.ArrayList;


public class AlertsFragment extends Fragment {

    AlertsAdapter adapterAlert;
    RecyclerView recyclerAlerts;
    ArrayList<Alerts> listaAlerts;


    public AlertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_alerts, container, false);
        recyclerAlerts = view.findViewById(R.id.recyclerAlerts);
        recyclerAlerts.setHasFixedSize(true);
        listaAlerts = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }

    public void cargarLista() {

        listaAlerts.add(new Alerts("hola amigos de odoo!!", R.drawable.odoo));
        listaAlerts.add(new Alerts("hola amigos de odoo!!", R.drawable.odoo));
        listaAlerts.add(new Alerts("hola amigos de odoo!!", R.drawable.odoo));
        listaAlerts.add(new Alerts("hola amigos de odoo!!", R.drawable.odoo));
        listaAlerts.add(new Alerts("hola amigos de odoo!!", R.drawable.odoo));



    }

    public void mostrarData() {
        recyclerAlerts.setLayoutManager(new GridLayoutManager(getContext(), 2));

        adapterAlert = new AlertsAdapter(getContext(), listaAlerts);
        recyclerAlerts.setAdapter(adapterAlert);

    }
}