package com.mijale.adaapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mijale.adaapp.Perfil;
import com.mijale.adaapp.R;
import com.mijale.adaapp.SendPost;

public class ProfileFragment extends Fragment {


    private static final int CAMERA_REQUEST = 1888;
    public static final int PICK_IMAGE = 1;
    public static final int GALLERY_REQUEST = 1;

    SharedPreferences.Editor editor;
    SharedPreferences preferences;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;

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

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getInstance("https://adaapp-f73d9-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Messages");
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


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

        DocumentReference docRef = fStore.collection("users").document(mAuth.getCurrentUser().getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        if (!document.contains("username")) {

                            tvNombre.setText("SIN DATOS");

                        } else {
                            tvNombre.setText(document.getString("username").toString());
                        }

                        if (!document.contains("pais")) {

                            tvPais.setText("SIN DATOS");

                        } else {
                            tvPais.setText(document.getString("pais").toString());
                        }

                        if (!document.contains("correo")) {

                            tvCorreo.setText("SIN DATOS");

                        } else {
                            tvCorreo.setText(document.getString("correo").toString());
                        }

                        if (!document.contains("telefono")) {

                            tvTelefono.setText("xxx xxx xxx");

                        } else {
                            tvTelefono.setText(document.getString("telefono").toString());
                        }

                        if (!document.contains("oficio")) {

                            tvOficio.setText("SIN DATOS");

                        } else {
                            tvOficio.setText(document.getString("oficio").toString());
                        }

                        if (!document.contains("github")) {

                            tvLink.setText("SIN DATOS");

                        } else {
                            tvLink.setText("github.com/" + document.getString("github").toString());
                        }
                    }
                } else {
                    tvNombre.setText("SIN DATOS");
                    tvPais.setText("SIN DATOS");
                    tvCorreo.setText("SIN DATOS");
                    tvTelefono.setText("xxx xxx xxx");
                    tvOficio.setText("SIN DATOS");
                    tvLink.setText("SIN DATOS");
                }
            }
        });

    }


}