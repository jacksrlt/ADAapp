package com.mijale.adaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {
    private Button  volver;
    private EditText emailTextView, passwordTextView;
    private TextView Btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Instancia de FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        //Inicializar vistas
        emailTextView = findViewById(R.id.Correo);
        passwordTextView = findViewById(R.id.contraseña);
        Btn = findViewById(R.id.regis);

        //Onclick Listener en Botón de registro
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
        volver=findViewById(R.id.volverLog);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

        private void registerNewUser(){
            //Tomar los valores de los EditText como String
            String email, password;
            email = emailTextView.getText().toString();
            password = passwordTextView.getText().toString();

            //Validación de email y contraseña
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, inserte una dirección de correo electrónico",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, inserte una contraseña",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }

            //Crear un nuevo usuario
            mAuth
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),
                                        "Usuario registrado",
                                        Toast.LENGTH_LONG)
                                        .show();

                                //Enviar a login si el usuario fue creado
                                Intent intent
                                        = new Intent(RegisterActivity.this,
                                        LoginActivity.class);
                                startActivity(intent);
                            } else {

                                // Registro fallido
                                Toast.makeText(
                                        getApplicationContext(),
                                        "No se ha creado el usuario, intente nuevamente",
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });
        }

    }