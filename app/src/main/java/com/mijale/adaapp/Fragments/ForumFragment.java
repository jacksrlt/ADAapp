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
        listaPersonas.add(new Persona("User","hola!!",R.drawable.common_google_signin_btn_icon_dark_normal_background));
        listaPersonas.add(new Persona("User2","holaaa!!",R.drawable.common_google_signin_btn_icon_dark_normal));
        listaPersonas.add(new Persona("User","hola!!",R.drawable.common_google_signin_btn_icon_dark_normal_background));
        listaPersonas.add(new Persona("User2","holaaa!!",R.drawable.common_google_signin_btn_icon_dark_normal));
        listaPersonas.add(new Persona("User","hola!!",R.drawable.common_google_signin_btn_icon_dark_normal_background));
        listaPersonas.add(new Persona("User2","holaaa!!",R.drawable.common_google_signin_btn_icon_dark_normal));
        listaPersonas.add(new Persona("User","hola!!",R.drawable.common_google_signin_btn_icon_dark_normal_background));
        listaPersonas.add(new Persona("User2","holaaa!!",R.drawable.common_google_signin_btn_icon_dark_normal));
        listaPersonas.add(new Persona("User","hola!!",R.drawable.common_google_signin_btn_icon_dark_normal_background));
        listaPersonas.add(new Persona("User2","holaaa!!",R.drawable.common_google_signin_btn_icon_dark_normal));
    }

    public void mostrarData(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterListas = new AdapterListas(getContext(), listaPersonas);
        recyclerViewPersonas.setAdapter(adapterListas);
    }
}

