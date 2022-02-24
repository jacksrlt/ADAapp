package com.mijale.adaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Prefil extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    public static final int PICK_IMAGE = 1;
    public static final int GALLERY_REQUEST = 1;
    Button btSubirImg,btguardar;
    ImageView circleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefil);


        btguardar=findViewById(R.id.btGuardar);
        btSubirImg =findViewById(R.id.btSubirImg);
        circleImageView =findViewById(R.id.circleImageView);

//        btSubirImg.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View view) {
////                AlertDialog.Builder ad = new AlertDialog.Builder(this)
////                        .create();
////                ad.setCancelable(false);
////                ad.setTitle("Foto de perfil");
////                ad.setButton("Camara", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        abirCamara();
////                    }
////                });
////                ad.setButton2("Galeria", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        abrirGaleria();
////                    }
////                });
////
////
////                ad.show();
////
////            }
////        });
////
////
////        return view;


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