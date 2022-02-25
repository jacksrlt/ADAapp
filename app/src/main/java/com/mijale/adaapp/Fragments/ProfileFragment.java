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
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

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

public class ProfileFragment extends Fragment {


//    private static final int CAMERA_REQUEST = 1888;
//    public static final int PICK_IMAGE = 1;
//    public static final int GALLERY_REQUEST = 1;
    private TextView tvNombre,tvPais,tvCorreo,tvTelefono,tvOficio,tvLink;
    private String nombre,pais,link,correo,oficio,telefono;
    private ImageView circleImageView;
    private ImageButton Editar;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Editar=view.findViewById(R.id.btEdit);

//        View contexto= view ;
//        SharedPreferences shpref = getActivity().getPreferences(contexto.MODE_PRIVATE);
        //btguardar=view.findViewById(R.id.btGuardar);
        //btSubirImg = view.findViewById(R.id.btSubirImg);
        circleImageView = view.findViewById(R.id.circleImageView);
        tvNombre=view.findViewById(R.id.tvNombre);
        tvPais=view.findViewById(R.id.tvPais);
        tvCorreo=view.findViewById(R.id.tvCorreo);
        tvTelefono=view.findViewById(R.id.tvTelefono);
        tvOficio=view.findViewById(R.id.tvOficio);
        tvLink=view.findViewById(R.id.tvLink);


//// esto es para inte
//        SharedPreferences shpref =getPreferences(context.MODE_PRIVATE);
//        nombre=shpref.getString("datoNombre","No hay dato");
//        pais=shpref.getString("datoPais","No hay dato");
//        correo=shpref.getString("datoCorreo","No hay dato");
//        telefono=shpref.getString("datoTelefono","No hay dato");
//        oficio=shpref.getString("datoOficio","No hay dato");
//        link=shpref.getString("datoLink","No hay dato");

        tvNombre.getText(nombre);
        tvPais.getText(pais);
        tvCorreo.getText(correo);
        tvTelefono.getText(telefono);
        tvOficio.getText(oficio);
        tvLink.getText(link);




        // onclick para ir a perfil
        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Prefil.class);
                startActivity(intent);
            }
        });

//        btSubirImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog ad = new AlertDialog.Builder(getContext())
//                        .create();
//                ad.setCancelable(false);
//                ad.setTitle("Foto de perfil");
//                ad.setButton("Camara", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        abirCamara();
//                    }
//                });
//                ad.setButton2("Galeria", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        abrirGaleria();
//                    }
//                });
//
//
//                ad.show();
//
//            }
//        });


        return view;


    }

//    private void abirCamara() {
//        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent, CAMERA_REQUEST);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK)
//            switch (requestCode) {
//                case GALLERY_REQUEST:
//                    Uri selectedImage;
//                    selectedImage = data.getData();
//                    circleImageView.setImageURI(selectedImage);
//                    break;
//                case CAMERA_REQUEST:
//                    Bitmap photo = (Bitmap) data.getExtras().get("data");
//                    circleImageView.setImageBitmap(photo);
//            }
//    }
//
//
//    private void abrirGaleria() {
//
//        Intent gallery = new Intent(Intent.ACTION_PICK,
//                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(gallery, PICK_IMAGE);
//
//
//    }


}