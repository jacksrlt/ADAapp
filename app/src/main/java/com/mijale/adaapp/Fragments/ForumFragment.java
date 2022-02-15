package com.mijale.adaapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mijale.adaapp.Adapters.AdapterListas;
import com.mijale.adaapp.Entidades.Persona;
import com.mijale.adaapp.PerfilActivity;
import com.mijale.adaapp.R;

import java.util.ArrayList;


public class ForumFragment extends Fragment {

    AdapterListas adapterListas;
    RecyclerView recyclerViewPersonas;
    ArrayList <Persona> listaPersonas;
    public ForumFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_forum, container, false);
        recyclerViewPersonas = view.findViewById(R.id.recycler);
        listaPersonas = new ArrayList<>();
        cargarLista();
        mostrarData();
    return view;
    }

    public void cargarLista(){
        listaPersonas.add(new Persona("Maria_laGuapa","Aqui os dejo la nueva noticia sobre phyton! " +
                "Aqui os dejo la nueva noticia sobre phyton! " +
                "Aqui os dejo la nueva noticia sobre phyton! " +
                "Aqui os dejo la nueva noticia sobre phyton! " +


                "",R.drawable.odoo));
        listaPersonas.add(new Persona("RamolaLaPechugona","holaaa!!",R.drawable.odoo));
        listaPersonas.add(new Persona("AlbaLaBernarda","holaaa!!",R.drawable.odoo));
        listaPersonas.add(new Persona("TuhMorenita69","holaaa!!",R.drawable.odoo));
        listaPersonas.add(new Persona("Rociiito1212","holaaa!!",R.drawable.odoo));
    }

    public void mostrarData(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterListas = new AdapterListas(getContext(), listaPersonas);
        recyclerViewPersonas.setAdapter(adapterListas);
    }
}

