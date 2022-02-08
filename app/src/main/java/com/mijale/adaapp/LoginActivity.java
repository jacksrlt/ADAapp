package com.mijale.adaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button invitado;
    private EditText emailTextView, passwordTextView;
    private TextView iniciarSesion;
    private TextView registro;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instancia de FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        //Inicializar vistas
        emailTextView = findViewById(R.id.logginUser);
        passwordTextView = findViewById(R.id.loginPassword);
        registro = findViewById(R.id.ReL);
        iniciarSesion = findViewById(R.id.EnL);

        //Onclick Listener para pantalla de registro
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegister);
            }
        });

        //Onclick Listener en Botón de inicio de sesión
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });


        invitado=findViewById(R.id.InL);
        invitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(inten);
                finish();
            }
        });
    }

    private void loginUserAccount()
    {
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

        //Iniciar sesión de usuario existente
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Bienvenid@",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    //Si se inicia sesión
                                    //Intent a activity home
                                    Intent intent
                                            = new Intent(LoginActivity.this,
                                            MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

                                else {

                                    //Inicio de sesión fallido
                                    Toast.makeText(getApplicationContext(),
                                            "No se ha podido iniciar sesión",
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });

    }

}