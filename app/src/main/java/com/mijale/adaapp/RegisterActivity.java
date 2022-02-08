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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {
    private Button  volver;
    private EditText emailTextView, passwordTextView, confirmPassTextView, userTextView;
    private TextView Btn;
    private FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Instancia de FirebaseAuth y FirebaseSFirestore
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        //Inicializar vistas
        userTextView = findViewById(R.id.user);
        emailTextView = findViewById(R.id.Correo);
        passwordTextView = findViewById(R.id.contraseña);
        confirmPassTextView = findViewById(R.id.repetircontra);
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
            String email, password, username, confirmpassword;
            username = userTextView.getText().toString();
            email = emailTextView.getText().toString();
            password = passwordTextView.getText().toString();
            confirmpassword = confirmPassTextView.getText().toString();

            //Validación de email, contraseña y usuario
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

            if (TextUtils.isEmpty(username)) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, inserte un nombre de usuario",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }

            if(!password.equals(confirmpassword)) {
                Toast.makeText(getApplicationContext(),
                        "Las contraseñas no coinciden",
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

                                //Crear colección para usuario con UID y añadir nombre de usuario
                                userID = mAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                Map<String, Object> userData = new HashMap<>();
                                userData.put("username", username);
                                documentReference.set(userData);
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