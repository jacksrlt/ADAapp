package com.mijale.adaapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mijale.adaapp.Perfil;
import com.mijale.adaapp.R;

public class ProfileFragment extends Fragment {


    private static final int CAMERA_REQUEST = 1888;
    public static final int PICK_IMAGE = 1;
    public static final int GALLERY_REQUEST = 1;

    SharedPreferences.Editor editor;
    SharedPreferences preferences;


    private TextView tvNombre, tvPais, tvCorreo, tvTelefono, tvOficio, tvLink;
    private String nombre, pais, link, correo, oficio, telefono;
    private ImageView circleImageView;
    Button btSubirImg, btguardar, btEditar;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        preferences = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        btEditar = view.findViewById(R.id.btEditar);
        btSubirImg = view.findViewById(R.id.btSubirImg);
        circleImageView = view.findViewById(R.id.circleImageView);


        circleImageView = view.findViewById(R.id.circleImageView);
        tvNombre = view.findViewById(R.id.tvNombre);
        tvPais = view.findViewById(R.id.tvPais);
        tvCorreo = view.findViewById(R.id.tvCorreo);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvOficio = view.findViewById(R.id.tvOficio);
        tvLink = view.findViewById(R.id.tvLink);
        load();


        // onclick para ir a perfil
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Perfil.class);
                startActivity(intent);
            }
        });


        return view;

    }


    public void load() {


        tvNombre.setText(preferences.getString("nombre", "SIN DATOS"));
        tvPais.setText(preferences.getString("pais", "SIN DATOS"));
        tvCorreo.setText(preferences.getString("correo", "SIN DATOS"));
        tvTelefono.setText(preferences.getString("telefono", "xxx xxx xxx"));
        tvOficio.setText(preferences.getString("oficio", "SIN DATOS"));
        tvLink.setText(preferences.getString("gitHub", "SIN DATOS"));
    }


}