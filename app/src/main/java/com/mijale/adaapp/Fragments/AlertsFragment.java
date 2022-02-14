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
import com.mijale.adaapp.Entidades.Persona;
import com.mijale.adaapp.R;

import java.util.ArrayList;


public class AlertsFragment extends Fragment {

    AdapterListas adapterListas;
    RecyclerView recyclerAlerts;
    ArrayList<Persona> listaPersonas;


    public AlertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_alerts, container, false);
        recyclerAlerts = view.findViewById(R.id.recyclerAlerts);
        listaPersonas = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }

    public void cargarLista() {
        listaPersonas.add(new Persona("User", "hola amigos de odoo!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User2", "holaaa!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User", "hola!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User2", "holaaa!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User", "hola!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User", "hola!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User", "hola!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User", "hola!!", R.drawable.odoo));
        listaPersonas.add(new Persona("User", "hola!!", R.drawable.odoo));

    }

    public void mostrarData() {

        recyclerAlerts.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapterListas = new AdapterListas(getContext(), listaPersonas);
        recyclerAlerts.setAdapter(adapterListas);
    }
}