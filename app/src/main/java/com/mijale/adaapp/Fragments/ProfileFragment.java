package com.mijale.adaapp.Fragments;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mijale.adaapp.LoginActivity;
import com.mijale.adaapp.MainActivity;
import com.mijale.adaapp.Prefil;
import com.mijale.adaapp.R;
import com.mijale.adaapp.SplashScreen;

import java.io.IOException;
import java.sql.Struct;

public class ProfileFragment extends Fragment {


    private static final int CAMERA_REQUEST = 1888;
    public static final int PICK_IMAGE = 1;
    public static final int GALLERY_REQUEST = 1;

    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    private TextView tvNombre, tvPais, tvCorreo, tvTelefono, tvOficio, tvLink;
    private String nombre, pais, link, correo, oficio, telefono;
    private ImageView circleImageView;
    private ImageButton btEdit;
    Button btSubirImg, btguardar;



    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        preferences = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        btguardar = view.findViewById(R.id.btGuardar);
        btSubirImg = view.findViewById(R.id.btSubirImg);
        circleImageView = view.findViewById(R.id.circleImageView);



        btEdit = view.findViewById(R.id.btEdit);
        circleImageView = view.findViewById(R.id.circleImageView);
        tvNombre = view.findViewById(R.id.tvNombre);
        tvPais = view.findViewById(R.id.tvPais);
        tvCorreo = view.findViewById(R.id.tvCorreo);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvOficio = view.findViewById(R.id.tvOficio);
        tvLink = view.findViewById(R.id.tvLink);
        load();







        // onclick para ir a perfil
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Prefil.class);
                startActivity(intent);
            }
        });


        return view;

    }


    public void load(){
        String nombre = preferences.getString("nombre", "SIN DATOS");
        String pais = preferences.getString("pais", "SIN DATOS");
        String correo = preferences.getString("correo", "SIN DATOS");
        String telefono = preferences.getString("telefono", "xxx xxx xxx");
        String oficio = preferences.getString("oficio", "SIN DATOS");
        String gitHub = preferences.getString("gitHub", "SIN DATOS");

        tvNombre.setText(nombre);
        tvPais.setText(pais);
        tvCorreo.setText(correo);
        tvTelefono.setText(telefono);
        tvOficio.setText(oficio);
        tvLink.setText(gitHub);
    }


}