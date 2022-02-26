package com.mijale.adaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.mijale.adaapp.Fragments.ProfileFragment;

public class Perfil extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    public static final int PICK_IMAGE = 1;
    public static final int GALLERY_REQUEST = 1;
    private Button btSubirImg, btguardar;
    private ImageView circleImageView;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    private TextInputEditText etNombre, etPais, etTelefono, etCorreo, etOficio, etGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefil);

        etOficio = findViewById(R.id.etOficio);
        etGithub = findViewById(R.id.etGithub);
        etTelefono = findViewById(R.id.etTelefono);
        etCorreo = findViewById(R.id.etCorreo);
        etNombre = findViewById(R.id.etNombre);
        etPais = findViewById(R.id.etPais);
        btguardar = findViewById(R.id.btGuardar);
        btSubirImg = findViewById(R.id.btSubirImg);


        preferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);




        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
                onBackPressed();

            }


        });

        btSubirImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog ad = new AlertDialog.Builder(Perfil.this)
                        .create();
                ad.setCancelable(false);
                ad.setTitle("Fuente de imagen");
                ad.setButton("Camara", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        abirCamara();
                    }
                });
                ad.setButton2("Galeria", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        abrirGaleria();
                    }
                });


                ad.show();

            }
        });

    }


    private void abirCamara() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST:
                    Uri selectedImage;
                    selectedImage = data.getData();

                    circleImageView.setImageURI(selectedImage);
                    break;
                case CAMERA_REQUEST:
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    circleImageView.setImageBitmap(photo);
            }

    }


    private void abrirGaleria() {

        Intent gallery = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);


    }

    private void guardarDatos() {
        SharedPreferences.Editor editor = preferences.edit();
        String nombre = etNombre.getText().toString();
        String pais = etPais.getText().toString();
        String correo = etCorreo.getText().toString();
        String telefono = etTelefono.getText().toString();
        String oficio = etOficio.getText().toString();
        String gitHub = etGithub.getText().toString();
        editor.putString("nombre","@"+ nombre);
        editor.putString("pais", "Pais:  "+pais);
        editor.putString("correo", "Correo: " + correo);
        editor.putString("telefono","Telefono:" +telefono);
        editor.putString("oficio","Trabaja en : "+ oficio);
        editor.putString("gitHub", "Github: "+ gitHub);
        editor.commit();
    }

    private void lanzar() {
        Intent intent = new Intent(this, ProfileFragment.class);
        startActivity(intent);
    }

}