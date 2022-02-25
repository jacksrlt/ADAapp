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
import android.widget.EditText;
import android.widget.ImageView;

public class Prefil extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    public static final int PICK_IMAGE = 1;
    public static final int GALLERY_REQUEST = 1;
    private Button btSubirImg,btguardar;
    private ImageView circleImageView;
    private EditText etNombre,etPais,etTelefono,etCorreo,etOficio,etLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefil);

        Context context=this;
        SharedPreferences shpref = getSharedPreferences("pref",context.MODE_PRIVATE);

        etOficio=findViewById(R.id.etOficio);
        etLink=findViewById(R.id.etlink);
        etTelefono=findViewById(R.id.etTelefono);
        etCorreo=findViewById(R.id.etCorreo);
        etNombre=findViewById(R.id.etNombre);
        etPais=findViewById(R.id.etPais);
        btguardar=findViewById(R.id.btGuardar);
        //metodo para guardar los datos
        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shpref =getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor=shpref.edit();
                editor.putString("datoNombre",etNombre.getText().toString());
                editor.putString("datoPais",etPais.getText().toString());
                editor.putString("datoCorreo",etCorreo.getText().toString());
                editor.putString("datoTelefono",etTelefono.getText().toString());
                editor.putString("datoOficio",etOficio.getText().toString());
                editor.putString("datoLink",etLink.getText().toString());
                editor.commit();

            }
        });
        btSubirImg =findViewById(R.id.btSubirImg);
        circleImageView =findViewById(R.id.circleImageView);

        btSubirImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(this)
                        .create();
                ad.setCancelable(false);
                ad.setTitle("Foto de perfil");
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


        return context;



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
}