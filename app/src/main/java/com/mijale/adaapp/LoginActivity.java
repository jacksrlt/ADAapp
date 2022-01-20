package com.mijale.adaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
private Button entrar,registro,invitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


          entrar=findViewById(R.id.EnL);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
         registro=findViewById(R.id.ReL);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
         invitado=findViewById(R.id.InL);
        invitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

       /* public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("Texto_centenas", centenas.getText().toString());
            setResult(RESULT_OK, intent);
            startActivity(intent);

        }*/
    }
}